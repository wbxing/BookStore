package com.bs.test;

import com.bs.bean.OrderItem;
import com.bs.dao.IOrderItemDAO;
import com.bs.dao.impl.OrderItemDAOImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemDAOImplTest {
    IOrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Test
    public void saveOrderItem() {
        System.out.println(orderItemDAO.saveOrderItem(new OrderItem(1, "order1",
                100.0, 200.0, 2, "123461")));
    }

    @Test
    public void queryOrderItemByOrderId() {
        System.out.println(orderItemDAO.queryOrderItemByOrderId("123461"));
    }
}