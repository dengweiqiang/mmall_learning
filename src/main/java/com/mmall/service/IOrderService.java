package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * Created by dengweiqiang on 2020/1/12
 */
public interface IOrderService {

    ServerResponse pay(Long orderNo, Integer userId, String path);
}
