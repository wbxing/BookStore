package com.bs.servlet;

import com.bs.bean.Cart;
import com.bs.bean.Order;
import com.bs.bean.OrderItem;
import com.bs.bean.User;
import com.bs.service.IOrderService;
import com.bs.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClientOrderServlet extends BaseServlet {
    private final IOrderService orderService = new OrderServiceImpl();

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.sendOrder(orderId);
        // 回到原界面
        resp.sendRedirect(req.getHeader("referer"));
    }

    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        req.setAttribute("orderItems", orderItems);
        req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req, resp);
    }

    protected void showMyOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
        } else {
            List<Order> orders = orderService.showMyOrders(user.getId());
            req.setAttribute("myOrder", orders);
            req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
        }
    }

    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.receiveOrder(orderId);
        // 回到原界面
        resp.sendRedirect(req.getHeader("referer"));
    }

}
