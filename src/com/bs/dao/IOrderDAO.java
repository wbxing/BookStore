package com.bs.dao;

import com.bs.bean.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface IOrderDAO {
    /**
     * 保存订单
     *
     * @param order 需要保存的订单
     * @return 返回影响的行数
     */
    int saveOrder(Order order);

    /**
     * 查询所有订单
     *
     * @return 返回查询得到的所有订单
     */
    List<Order> queryAllOrders();

    /**
     * 修改订单状态
     *
     * @param orderId 需要修改状态的订单编号
     * @param status  修改后的状态
     * @return 返回修改影响的数据行数
     */
    int changeOrderStatus(String orderId, Integer status);

    /**
     * 根据用户编号查询订单
     *
     * @param userId 用户编号
     * @return 返回查询得到的订单
     */
    List<Order> queryOrderByUserId(Integer userId);
}
