package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.util.Map;

/**
 * Created by dengweiqiang on 2020/1/12
 */
public interface IOrderService {

    /**
     * 支付订单
     * @param orderNo
     * @param userId
     * @param path
     * @return
     */
    ServerResponse pay(Long orderNo, Integer userId, String path);

    /**
     * 支付宝回调接口
     * @param params
     * @return
     */
    ServerResponse alipayCallback(Map<String, String> params);

    /**
     * 查询订单状态
     * @param userId
     * @param orderNo
     * @return
     */
    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);
}
