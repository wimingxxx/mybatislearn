package com.qwm.mybatis.mapper;

import com.qwm.mybatis.pojo.Orders;
import com.qwm.mybatis.pojo.OrdersCustom;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2018/1/7 0007
 * @description：
 * 订单相关查询的接口
 */
public interface OrdersMapper {
    //一对一查询，查询订单关联查询用户
    List<OrdersCustom> findOrderUserList() throws Exception;

    //一对一查询，查询订单关联查询用户(resultMap实现)
    List<OrdersCustom> findOrderUserListResultMap() throws Exception;

    //一对多查询，查询订单关联查询用户(resultMap实现)
    List<Orders> findOderAndOrderDetails() throws Exception;

    //一对一查询，延迟加载
    List<Orders> findOrderUserListLazyLoading() throws Exception;
}
