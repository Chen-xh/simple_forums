<%@ page import="javax.xml.ws.Response" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<head>
    <meta charset="UTF-8">
    <title>index</title>
    <link rel="stylesheet" type="text/css" href="css/my.css"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="./js/http_cdn.staticfile.org_jquery_1.10.2_jquery.js"></script>
</head>
<SCRIPT>
    $(function () {
        let password = false;
        let passwordSure = false;
        $("#password").blur(function () {
            if ($(this).val() == "") {
                password = false;
            } else {
                password = true;
            }
        });
        $("#checkPassword").blur(function () {
            if ($(this).val() == "" || $(this).val() != $("#password").val()) {
                passwordSure = false;
            } else {
                passwordSure = true;
            }
        });
        $(":submit").click(function () {
            if (passwordSure == false || password == false) {
                alert("密码不一致");
                return false;
            }else {
                top.window.location.replace("/ssm9/login.jsp");
            }
        })
    });


</SCRIPT>
<body>
<div class="user_container">
    <div class="user_box">

        <HR color=#d5caca SIZE=1>
        <!-- 表单区域 -->
        <form action="modifyPassword" method="post">
            <div>
                <h2>Password</h2>
            </div>
            <div>
                <label for="id"></label>
                <input style=" visibility:hidden" type="text" id="id" name="id" value="${sessionScope.user.id}"/>
            </div>
            <div>
                <label for="password" class="itemLabel2">输入新密码</label>
                <input class="input_text2 " type="password" id="password" name="password"/>
            </div>
            <div>
                <label for="checkPassword" class="itemLabel2">确认新密码</label>
                <input class="input_text2 " type="password" id="checkPassword" name="checkPassword"/>
            </div>
            <p class="error"> ${message}</p>
            <div class="btn">
                <button type="submit" class="form_btn2">确定</button>
                <button type="reset" class="form_btn2">重置</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>