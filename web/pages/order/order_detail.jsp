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
    <span class="wel_word">订单详情</span>
    <%-- 静态包含 jsp 页面 --%>
    <%@include file="/pages/common/welcome.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
        </tr>
        <c:if test="${not empty requestScope.orderItems}">
            <c:forEach items="${requestScope.orderItems}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>
                        ${item.count}

                    </td>
                    <td>${item.price}</td>
                    <td>${item.totalMoney}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>

<%--静态包含底部信息的 jsp 文件--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>