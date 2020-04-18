<%--
  Created by IntelliJ IDEA.
  User: xingw
  Date: 2020/3/27 027
  Time: 下午 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临网上书城</span>
    <a href="order?action=showMyOrder">我的订单</a>
    <a href="user?action=logout">注销</a>
    <a href="index.jsp">返回</a>
</div>
