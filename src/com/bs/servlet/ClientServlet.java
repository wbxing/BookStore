package com.bs.servlet;

import com.bs.bean.Book;
import com.bs.bean.Page;
import com.bs.service.IBookService;
import com.bs.service.impl.BookServiceImpl;
import com.bs.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client")
public class ClientServlet extends BaseServlet {

    IBookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        // pageNo, pageSize
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        // pageNo, pageSize
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client?action=pageByPrice");
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

}
