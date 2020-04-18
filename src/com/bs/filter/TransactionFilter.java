package com.bs.filter;

import com.bs.util.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
            // 提交事务
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            // 回滚事务
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            // 将异常抛给服务器进行统一处理
            throw new RuntimeException();
        }
    }

    @Override
    public void destroy() {

    }
}
