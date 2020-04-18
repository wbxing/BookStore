package com.bs.dao;

import com.bs.bean.Order;
import com.bs.bean.OrderItem;

import java.util.List;

public interface IOrderItemDAO {
    /**
     * 保存订单项
     * @param orderItem  需要保存的订单项
     * @return 返回保存的行数
     */
    int saveOrderItem(OrderItem orderItem);

    /**
     * 根据用户编号查询订单项
     *
     * @param orderId 用户编号
     * @return 返回查询得到的订单项信息
     */
    List<OrderItem> queryOrderItemByOrderId(String orderId);
}
