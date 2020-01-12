package com.mmall.service.impl;

import com.alipay.api.domain.ExtendParams;
import com.google.common.collect.Maps;
import com.mmall.common.ServerResponse;
import com.mmall.dao.OrderMapper;
import com.mmall.pojo.Order;
import com.mmall.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by dengweiqiang on 2020/1/12
 */
public class IOrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ServerResponse pay(Long orderNo, Integer userId, String path) {
        Map<String, String> resultMap = Maps.newHashMap();
        Order order = orderMapper.selectByUserIdAndOrderNo(userId, orderNo);
        if (order == null) {
            return ServerResponse.createByErrorMessage("用户没有该订单");
        }
        resultMap.put("orderNo", String.valueOf(order.getOrderNo()));

        // （必填）商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
        // 需保证商户系统端不能重复，建议通过数据库sequence生成
        String outTradeNo = order.getOrderNo().toString();

        // （必填）订单标题，粗略描述用户的支付目的。如“xxx品牌xxx门店当面付扫码消费”
        String subject = new StringBuilder().append("happymmall扫码支付，订单号: ").append(outTradeNo).toString();

        // (必填) 订单总金额，单位为元，不能超过1亿元
        // 如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】
        String totalAmount = order.getPayment().toString();

        // (可选)订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
        // 如果该值未传入，但传入了【订单总金额】，【打折金额】，则该值默认为【订单总金额】-【打折金额】
        String undiscounttableAmount = "0";


        // 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账户，（打款到sellerId对应的支付宝账号）
        // 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
        String sellerId = "";

        // 订单描述，可以对交易或商品进行一个详细地描述，比如填写“购买商品两件共15.00元”
        String body = new StringBuilder().append("订单").append(outTradeNo).append("购买商品共").append(totalAmount).append("元").toString();

        // 商户操作员编号，添加此参数可以为商户操作员做销售统计
        String operatorId = "test_operator_id";

        //（必填） 商户门店编号，通过门店号和商家后台可以配置精准到门店的打折信息，详询支付宝技术支持
        String storeId = "test_store_id";

        // 业务扩展参数，目前可添加由支付宝分配的系统商编号（通过setSysServiceProviderId方法），详情请咨询支付宝技术支持
        ExtendParams extendParams = new ExtendParams();
        extendParams.setSysServiceProviderId("2088100200300400500");
        return null;
    }
}
