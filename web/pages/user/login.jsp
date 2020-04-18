<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上书城会员登录</title>
    <%--静态包含头部信息的 jsp 文件--%>
    <%@include file="/pages/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            // 给登录绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名不为空
                const usernameText = $("#username").val().trim();
                const $spanErrorMsg = $("span.errorMsg");
                if (usernameText === null || usernameText.length === 0) {
                    $spanErrorMsg.text("请输入用户名");
                    return false;
                }
                // 验证密码不为空
                const passwordText = $("#password").val();

                if (passwordText == null || passwordText.length === 0) {
                    $spanErrorMsg.text("请输入密码");
                    return false;
                }
                // 去掉错误信息
                $spanErrorMsg.text("");
            });
        });
    </script>
</head>
<body>
<div id="header">
    <!--    <img class="logo_img" alt="" src="static/img/logo.gif">-->
    <span class="wel_word">网上书城</span>
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>网上书城会员</h1>
                    <a href="pages/user/register.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        ${empty requestScope.msg?"请输入用户名和密码":requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="user" method="post">
                        <label><input type="hidden" name="action" value="login"></label>
                        <label>用户名称：</label>
                        <label><input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                                      name="username" id="username"
                        <%--                               value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
                                      value="${requestScope.username}"
                        /></label>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <label><input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                                      name="password" id="password"
                        <%--                               value="<%=request.getAttribute("password")==null?"":request.getAttribute("password")%>"--%>
                                      value="${requestScope.password}"
                        /></label>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--静态包含底部信息的 jsp 文件--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>