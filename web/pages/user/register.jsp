<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上书城会员注册</title>
    <%--静态包含头部信息的 jsp 文件--%>
    <%@include file="/pages/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#username").blur(function () {
                // 获取用户名
                const username = this.value;
                const $spanErrorMsg = $("span.errorMsg");
                $.getJSON("${basePath}user", "action=ajaxExistUsername&username=" + username, function (data) {
                    if (data.existUsername) {
                        $spanErrorMsg.text("用户名已存在！");
                    } else {
                        $spanErrorMsg.text("");
                    }
                })
            });

            // 刷新验证码
            $("#code_img").click(function () {
                this.src = "${basePath}code.jpg?d=" + new Date();
            });
            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                // 1 获取用户名输入框里的内容
                const usernameText = $("#username").val();
                // 2 创建正则表达式对象
                const userNameRegExp = /^\w{5,12}$/;
                // 错误信息
                const $spanErrorMsg = $("span.errorMsg");
                // 3 使用test方法验证
                if (!userNameRegExp.test(usernameText)) {
                    // 4 提示用户结果
                    $spanErrorMsg.text("用户名不合法！");
                    return false;
                }
                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                // 1 获取用户名输入框里的内容
                const passwordText = $("#password").val();
                // 2 创建正则表达式对象，至少 5 位
                const passwordRegExp = /^\w{5,}$/;
                // 3 使用test方法验证
                if (!passwordRegExp.test(passwordText)) {
                    //4 提示用户结果
                    $spanErrorMsg.text("密码不合法！");
                    return false;
                }

                // 验证确认密码：和密码相同
                // 1 获取确认密码内容
                const val = $("#repwd").val();
                // 2 和密码相比较
                if (val !== passwordText) {
                    //3 提示用户
                    $spanErrorMsg.text("确认密码和密码不一致！");
                    return false;
                }
                // 邮箱验证：xxxxx@xxx.com
                // 1 获取邮箱里的内容
                const emailText = $("#email").val();
                // 2 创建正则表达式对象
                const emailRegExp = /^[a-z\w]+(\.\w+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                // 3 使用test方法验证是否合法
                if (!emailRegExp.test(emailText)) {
                    //4 提示用户
                    $spanErrorMsg.text("邮箱格式不合法！");
                    return false;
                }
                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                let codeText = $("#code").val();
                // 去掉验证码前后空格
                // alert("去空格前：["+codeText+"]")
                codeText = $.trim(codeText);
                // alert("去空格后：["+codeText+"]")
                if (codeText == null || codeText === "") {
                    //4 提示用户
                    $spanErrorMsg.text("验证码不能为空！");
                    return false;
                }
                // 去掉错误信息
                $spanErrorMsg.text("");
            });
        });
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
</head>
<body>
<!--显示 logo 图片-->
<div id="header">
    <!--    <img class="logo_img" alt="" src="static/img/logo.gif">-->
    <span class="wel_word">网上书城</span>
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册网上书城会员</h1>
                    <span class="errorMsg">
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="user" method="post">
                        <label><input type="hidden" name="action" value="register"></label>
                        <label>用户名称：</label>
                        <label for="username"></label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username"
                               value="${requestScope.username}"
                        />
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <label for="password"></label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"
                               value="${requestScope.password}"
                        />
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <label for="repwd"></label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"
                               value="${requestScope.repwd}"
                        />
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <label for="email"></label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1" name="email" id="email"
                               value="${requestScope.email}"
                        />
                        <br/>
                        <br/>
                        <label>&nbsp;&nbsp;&nbsp;&nbsp;验证码：</label>
                        <label for="code"></label>
                        <input class="itxt" type="text" style="width: 120px;" id="code" name="code"/>
                        <img id="code_img" alt="" src="code.jpg"
                             style="float: right; margin-right: 40px; width: 90px; height: 38px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
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