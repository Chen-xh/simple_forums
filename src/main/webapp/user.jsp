<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>home</title>

    <link rel="stylesheet" type="text/css" href="css/my.css"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="./js/http_cdn.staticfile.org_jquery_1.10.2_jquery.js"></script>
</head>
<SCRIPT>
    function modifyUser(){
        $(".input_text2").removeAttr("disabled")
        $(".btn1").css("visibility","visible")
        $(".btn2").css("visibility","hidden")
    }
</SCRIPT>
<body >
<div class="user_container" >
    <div class="user_box">

        <HR color=#d5caca SIZE=1>
        <!-- 表单区域 -->
        <form action="modify" method="post">
            <div style="float: left ;width: 50%;height: 260px">
                <div>
                    <h2>User</h2>
                </div>
                <div>
                    <label for="id" ></label>
                    <input style=" visibility:hidden" type="text" id="id" name="id" value="${sessionScope.user.id}"/>
                </div>
                <div>
                    <label for="username" class="itemLabel">用户名</label>
                    <input class="input_text2 text2" disabled="disabled" type="text" id="username" name="username"
                           value="${sessionScope.user.username}"/>
                </div>
                <div>
                    <label for="age" class="itemLabel">年龄</label>
                    <input class="input_text2 text2" disabled="disabled" type="text" id="age" name="age"
                           value="${sessionScope.user.age}"/>
                </div>
                <div>
                    <label for="phone" class="itemLabel">联系电话</label>
                    <input class="input_text2 text2" disabled="disabled" type="text" id="phone" name="phone"
                           value="${sessionScope.user.phone}"/>
                </div>

            </div>
            <div style="float: right;width: 50%;height: 260px">
                <div >
                    <img class="logo" style="width: 90px;height: 90px" src="images/logo.jpg">
                </div>
                <div>
                    <label for="email" class="itemLabel">邮箱</label>
                    <input class="input_text2 text2" disabled="disabled" type="text" id="email" name="email"
                           value="${sessionScope.user.email}"/>
                </div>
                <div>
                    <label for="rode" class="itemLabel">角色</label>
                    <input class="input_text2 text2" disabled="disabled" type="text" id="rode" name="rode"
                           value="${sessionScope.user.rode}"/>
                </div>
            </div>
            <p class="error"> ${message}</p>
            <div class="btn btn2">
                <button type="button" class="form_btn2" onclick="modifyUser()">修改</button>
            </div>
            <div class="btn btn1" style=" visibility:hidden">
                <button type="submit" class="form_btn2">确定</button>
                <button type="reset" class="form_btn2">重置</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>