package com.mmall.controller.security;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by dengweiqiang on 2020/1/3
 */
@Aspect
@Component
public class UserSecurityManagement {

    @Autowired
    private IUserService iUserService;

    @Pointcut("execution(public com.mmall.common.ServerResponse com.mmall.controller.backend.*.*(javax.servlet.http.HttpSession, ..))")
    private void adminPrivilege() {}

    /**
     * 对后台管理的方法进行权限的校验，避免冗余代码
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("adminPrivilege()")
    public ServerResponse aroundAdminAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取方法的第一个参数，约定为 HttpSession
        HttpSession session = (HttpSession) joinPoint.getArgs()[0];
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGING.getCode(), "用户未登录，请登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            // 执行目标方法
            return (ServerResponse) joinPoint.proceed();
        } else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

}
