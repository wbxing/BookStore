package com.bs.test;

import com.bs.bean.Cart;
import com.bs.bean.CartItem;
import com.bs.service.IOrderService;
import com.bs.service.impl.OrderServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    IOrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(2, "Database", 1, 99.0, 99.0));
        // cart.addItem(new CartItem(1, "Java", 1, 100.0, 100.0));
        cart.addItem(new CartItem(2, "Database", 1, 99.0, 99.0));
        cart.addItem(new CartItem(3, "Cpp", 1, 100.0, 100.0));
        System.out.println(orderService.createOrder(cart, 2));
    }

    @Test
    public void showAllOrders() {
        System.out.println(orderService.showAllOrders());
    }

    @Test
    public void sendOrder() {
        System.out.println(orderService.sendOrder("15861566503921"));
    }

    @Test
    public void showMyOrders() {
        System.out.println(orderService.showMyOrders(1));
    }

    @Test
    public void receiveOrder() {
        System.out.println(orderService.receiveOrder("15861566503921"));
    }

    @Test
    public void showOrderDetail() {
        System.out.println(orderService.showOrderDetail("15861566503921"));
    }
}