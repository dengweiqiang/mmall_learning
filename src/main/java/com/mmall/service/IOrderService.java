package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

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

    /**
     * 创建订单
     * @param userId
     * @param shippingId
     * @return
     */
    ServerResponse createOrder(Integer userId, Integer shippingId);

    /**
     * 取消订单（只能取消未付款的订单）
     * @param userId
     * @param orderNo
     * @return
     */
    ServerResponse cancel(Integer userId, Long orderNo);

    /**
     * 获取购物车中选中的产品生成订单
     * @param userId
     * @return
     */
    ServerResponse getOrderCartProduct(Integer userId);

    /**
     * 获取订单详情
     * @param userId
     * @param orderNo
     * @return
     */
    ServerResponse getOrderDetail(Integer userId, Long orderNo);

    /**
     * 查询所有订单
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse getOrderList(Integer userId, int pageNum, int pageSize);

    /**
     * 管理员查询订单
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    /**
     * 管理员查询订单详情
     * @param orderNo
     * @return
     */
    ServerResponse<OrderVo> manageDetail(Long orderNo);

    /**
     * 管理员搜索订单
     * @param orderNo
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    /**
     * 订单发货
     * @param orderNo
     * @return
     */
    ServerResponse<String> manageSendGoods(Long orderNo);
}
