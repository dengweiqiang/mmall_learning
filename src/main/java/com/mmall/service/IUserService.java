package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by dengweiqiang on 2020/1/2
 */
public interface IUserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 注册
     * @param user
     * @return
     */
    ServerResponse<String> register(User user);

    /**
     * 校验用户名或邮箱
     * @param str
     * @param type
     * @return
     */
    ServerResponse<String> checkValid(String str, String type);

    /**
     * 查询密保问题
     * @param username
     * @return
     */
    ServerResponse<String> selectQuestion(String username);

    /**
     * 校验密保答案
     * @param username
     * @param question
     * @param answer
     * @return
     */
    ServerResponse<String> checkAnswer(String username, String question, String answer);

    /**
     * 根据密保问题重置密码
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken);

    /**
     * 重置当前用户密码
     * @param passwordOld
     * @param passwordNew
     * @param user
     * @return
     */
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    /**
     * 更新当前用户信息
     * @param user
     * @return
     */
    ServerResponse<User> updateInformation(User user);

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    ServerResponse<User> getInformation(Integer userId);

    /**
     * 校验是否是管理员
     * @param user
     * @return
     */
    ServerResponse checkAdminRole(User user);
}
