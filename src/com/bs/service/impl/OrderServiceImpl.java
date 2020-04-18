package com.bs.service.impl;

import com.bs.bean.*;
import com.bs.dao.IBookDAO;
import com.bs.dao.IOrderDAO;
import com.bs.dao.IOrderItemDAO;
import com.bs.dao.impl.BookDAOImpl;
import com.bs.dao.impl.OrderDAOImpl;
import com.bs.dao.impl.OrderItemDAOImpl;
import com.bs.service.IOrderService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements IOrderService {
    private IOrderDAO orderDAO = new OrderDAOImpl();
    private IOrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private IBookDAO bookDAO = new BookDAOImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Timestamp(System.currentTimeMillis()).toString().substring(0, 19),
                cart.getTotalPrice(), Order.NOT_SHIPPED, userId);
        orderDAO.saveOrder(order);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getPrice(), cartItem.getTotalPrice(), cartItem.getCount(), orderId);
            orderItemDAO.saveOrderItem(orderItem);
            Book book = bookDAO.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDAO.updateBook(book);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDAO.queryAllOrders();
    }

    @Override
    public int sendOrder(String orderId) {
        return orderDAO.changeOrderStatus(orderId, Order.SHIPPED);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDAO.queryOrderByUserId(userId);
    }

    @Override
    public int receiveOrder(String orderId) {
        return orderDAO.changeOrderStatus(orderId, Order.SIGNED);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDAO.queryOrderItemByOrderId(orderId);
    }
}
