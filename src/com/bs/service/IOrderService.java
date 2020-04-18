package com.bs.service;

import com.bs.bean.Cart;
import com.bs.bean.Order;
import com.bs.bean.OrderItem;

import java.util.List;

public interface IOrderService {
    /**
     * 创建订单
     *
     * @param cart   购物车信息
     * @param userId 用户编号
     * @return 返回影响的数据行数
     */
    String createOrder(Cart cart, Integer userId);

    /**
     * 展示多有订单
     *
     * @return 返回查询结果
     */
    List<Order> showAllOrders();

    /**
     * 发货
     *
     * @param orderId 需要发货的订单编号
     * @return 返回影响的数据行数
     */
    int sendOrder(String orderId);

    /**
     * 查询用户订单
     *
     * @param userId 用户编号
     * @return 返回查询结果
     */
    List<Order> showMyOrders(Integer userId);

    /**
     * 收货
     *
     * @param orderId 订单编号
     * @return 返回影响的数据行数
     */
    int receiveOrder(String orderId);

    /**
     * 订单详情
     *
     * @param orderId 订单编号
     * @return 返回查询结果
     */
    List<OrderItem> showOrderDetail(String orderId);
}
