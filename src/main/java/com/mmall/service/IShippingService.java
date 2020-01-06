package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

/**
 * Created by dengweiqiang on 2020/1/6
 */
public interface IShippingService {
    /**
     * 新增地址
     * @param userId
     * @param shipping
     * @return
     */
    ServerResponse add(Integer userId, Shipping shipping);

    /**
     * 删除地址
     * @param userId
     * @param shippingId
     * @return
     */
    ServerResponse del(Integer userId, Integer shippingId);

    /**
     * 更新地址
     * @param userId
     * @param shipping
     * @return
     */
    ServerResponse update(Integer userId, Shipping shipping);

    /**
     * 查询地址详情
     * @param userId
     * @param shippingId
     * @return
     */
    ServerResponse select(Integer userId, Integer shippingId);

    /**
     * 查询地址列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse list(Integer userId, Integer pageNum, Integer pageSize);
}
