<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--静态包含头部信息的 jsp 文件--%>
    <%@include file="/pages/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteItem").click(function () {
                return confirm("确定要删除" + $(this).parent().parent().find("td:first").text() + "?");
            });
            $("#clear").click(function () {
                return confirm("确定清空购物车吗?");
            });
            $(".updateCount").change(function () {
                let name = $(this).parent().parent().find("td:first").text();
                let count = this.value;
                let id = $(this).attr("bookId");
                if (confirm("确定将" + name +"的数量修改为" + count +"?")) {
                    location.href = "${basePath}cart?action=updateCount&id=" + id + "&count=" + count;
                } else {
                    this.value = this.defaultValue;
                }
            });

        });
    </script>
</head>
<body>

<div id="header">
    <%--			<img class="logo_img" alt="" src="static/img/logo.gif" >--%>
    <span class="wel_word">购物车</span>
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
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">购物车为空</a></td>
            </tr>
        </c:if>

        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <label>
                            <input class="updateCount" style="width: 50px"
                                   bookId="${entry.value.id}" type="text" value="${entry.value.count}"/>
                        </label>
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cart?action=deleteFromCart&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span" id="clear"><a href="cart?action=clearCart">清空购物车</a></span>
            <span class="cart_span"><a href="manager/order?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%--静态包含底部信息的 jsp 文件--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>