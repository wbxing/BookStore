package com.bs.test;

import com.bs.bean.Cart;
import com.bs.bean.CartItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart = new Cart();

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Java", 1, 100.0, 100.0));
        cart.addItem(new CartItem(2, "Database", 1, 99.0, 99.0));
        cart.addItem(new CartItem(1, "CPP", 1, 100.0, 100.0));
        cart.addItem(new CartItem(2, "Database", 1, 99.0, 99.0));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1, "Java", 1, 100.0, 100.0));
        cart.addItem(new CartItem(1, "CPP", 1, 100.0, 100.0));
        cart.addItem(new CartItem(2, "Database", 1, 99.0, 99.0));
        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1, "Java", 1, 100.0, 100.0));
        cart.addItem(new CartItem(1, "CPP", 1, 100.0, 100.0));
        cart.addItem(new CartItem(2, "Database", 1, 99.0, 99.0));
        System.out.println(cart);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1, "CPP", 1, 100.0, 100.0));
        cart.addItem(new CartItem(2, "Database", 1, 99.0, 99.0));
        System.out.println(cart);
        cart.clear();
        System.out.println(cart);
        cart.addItem(new CartItem(1, "Java", 1, 100.0, 100.0));
        System.out.println(cart);
        cart.updateCount(1, 10);
        System.out.println(cart);
    }
}