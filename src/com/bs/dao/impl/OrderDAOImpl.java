package com.bs.dao.impl;

import com.bs.bean.Order;
import com.bs.dao.BaseDAO;
import com.bs.dao.IOrderDAO;

import java.util.List;

public class OrderDAOImpl extends BaseDAO implements IOrderDAO {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order (`order_id`,`create_time`,`total_money`,`status`,`user_id`) values (?,?,?,?,?)";

        return update(sql, order.getOrderId(), order.getCreateTime(), order.getTotalMoney(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> queryAllOrders() {
        String sql = "select `order_id` orderId,`create_time` createTime,`total_money` totalMoney,`status`,`user_id` userId from t_order ";
        return queryForList(Order.class, sql);
    }

    @Override
    public int changeOrderStatus(String orderId, Integer status) {
        String sql = "UPDATE t_order SET `status`=? WHERE order_id=?";
        return update(sql, status, orderId);
    }

    @Override
    public List<Order> queryOrderByUserId(Integer userId) {
        String sql = "select `order_id` orderId,`create_time` createTime,`total_money` totalMoney,`status`,`user_id` userId " +
                " from t_order where `user_id` = ?";
        return queryForList(Order.class, sql, userId);
    }
}
