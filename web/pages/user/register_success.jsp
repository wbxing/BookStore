<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上书城会员注册</title>
    <%--静态包含头部信息的 jsp 文件--%>
    <%@include file="/pages/common/header.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
<div id="header">
    <!--				<img class="logo_img" alt="" src="static/img/logo.gif" >-->
    <span class="wel_word">网上书城</span>
    <%-- 静态包含 jsp 页面 --%>
    <%@include file="/pages/common/welcome.jsp" %>
</div>

<div id="main">

    <h1>注册成功! <a href="index.jsp">转到主页</a></h1>

</div>

<%--静态包含底部信息的 jsp 文件--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>