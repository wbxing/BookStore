<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <%--静态包含头部信息的 jsp 文件--%>
    <%@include file="/pages/common/header.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <!--			<img class="logo_img" alt="" src="static/img/logo.gif" >-->
    <span class="wel_word">我的订单</span>
    <%-- 静态包含 jsp 页面 --%>
    <%@include file="/pages/common/welcome.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
        <c:forEach items="${requestScope.myOrder}" var="order">
            <tr>
                <td>${order.createTime}</td>
                <td>${order.totalMoney}</td>
                <td>
                    <c:choose>
                        <c:when test="${order.status == 0}">
                            未发货
                        </c:when>
                        <c:when test="${order.status == 1}">
                            <a href="order?action=receiveOrder&orderId=${ order.orderId }">确认收货</a>
                        </c:when>
                        <c:when test="${order.status == 2}">
                            已签收
                        </c:when>
                    </c:choose>
                </td>
                <td><a href="order?action=showOrderDetail&orderId=${ order.orderId }">查看详情</a></td>
            </tr>
        </c:forEach>
    </table>


</div>

<%--静态包含底部信息的 jsp 文件--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>