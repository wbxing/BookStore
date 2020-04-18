package com.bs.servlet;

import com.bs.bean.Cart;
import com.bs.bean.Order;
import com.bs.bean.OrderItem;
import com.bs.bean.User;
import com.bs.service.IOrderService;
import com.bs.service.impl.OrderServiceImpl;
import com.bs.util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManagerOrderServlet extends BaseServlet {
    private final IOrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
        } else {
            Integer userId = user.getId();
            String orderId = orderService.createOrder(cart, userId);
            req.getSession().setAttribute("orderId", orderId);
            resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
        }
    }

    protected void showAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
        } else {
            List<Order> orders = orderService.showAllOrders();
            req.setAttribute("AllOrders", orders);
            req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
        }
    }

}
