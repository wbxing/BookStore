package com.bs.dao.impl;

import com.bs.bean.Order;
import com.bs.bean.OrderItem;
import com.bs.dao.BaseDAO;
import com.bs.dao.IOrderItemDAO;

import java.util.List;

public class OrderItemDAOImpl extends BaseDAO implements IOrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`id`,`name`,`price`,`total_money`,`count`,`order_id`) " +
                " values(?,?,?,?,?,?)";
        return update(sql, orderItem.getId(), orderItem.getName(), orderItem.getPrice(),
                orderItem.getTotalMoney(), orderItem.getCount(), orderItem.getOrderId());

    }

    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId) {
        String sql = "select id,name,price,total_money totalMoney,count,order_id orderId " +
                " from t_order_item where order_id = ?";
        return queryForList(OrderItem.class, sql, orderId);
    }
}
