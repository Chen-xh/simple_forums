<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">

    <title>index</title>

    <link rel="stylesheet" type="text/css" href="css/my.css"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="./js/http_cdn.staticfile.org_jquery_1.10.2_jquery.js"></script>
</head>

<script>
    function exit() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/ssm9/exit",
            success: function (data) {
                window.location.href = "/ssm9/index.jsp";
            }
        });
    }

    $().ready(function () {
        home();
        if (${sessionScope.user!=null}) {
            $("#header_login").hide();
            $("#header_regedit").hide();
        } else {
            $("#header_out").hide();
        }
    })

    function loginBtn() {
        window.location.href = '/ssm9/login.jsp';
    }

    function regeditBtn() {
        window.location.href = '/ssm9/regedit.jsp';
    }

    function home() {
            $("#home").css("background", "#3D84FF")
            $("#test").css("color", "#fff")
            $("#myframe").attr("src", "home.jsp");

            $("#test1").css("color", "#000")
            $("#userHome").css("background", "#fff")
            $("#test2").css("color", "#000")
            $("#mdpass").css("background", "#fff")

    }

    function userHome() {
        if (${sessionScope.user!=null}) {
            $("#userHome").css("background", "#3D84FF")
            $("#test1").css("color", "#fff")
            $("#myframe").attr("src", "user.jsp");

            $("#test2").css("color", "#000")
            $("#mdpass").css("background", "#fff")
            $("#test").css("color", "#000")
            $("#home").css("background", "#fff")
        } else {
            alert("请先登录！")
        }
    }

    function modifyPassword() {
        if (${sessionScope.user!=null}) {
            $("#mdpass").css("background", "#3D84FF")
            $("#test2").css("color", "#fff")
            $("#myframe").attr("src", "modifyPassword.jsp");

            $("#test1").css("color", "#000")
            $("#userHome").css("background", "#fff")
            $("#test").css("color", "#000")
            $("#home").css("background", "#fff")
        } else {
            alert("请先登录！")
        }
    }
</script>
<body style="margin: 0;padding: 0">

<div style="background: #faf6f6;">
    <div class="header">
        <div class="header_start">
        </div>
        <div style="float:right;">
            <button onclick="loginBtn()" class="header_btn" id="header_login">登录</button>
            <button onclick="regeditBtn()" class="header_btn" id="header_regedit">注册</button>
            <button onclick="exit()" class="header_btn" id="header_out">退出</button>
        </div>
    </div>
    <div>
        <div class="sidebar">
            <img class="logo" src="images/logo.jpg">
            <div>
                <span id="">Hi！${sessionScope.user.username}</span>
            </div>
            <HR color=#d5caca SIZE=1>
            <div class="index_btn" id="home" onclick="home()">
                <i class=" fa fa-home"></i>
                <span id="test">&emsp;首页&emsp;</span>
            </div>
            <div class="index_btn" id="userHome" onclick="userHome()">
                <i class=" fa fa-user-circle"></i>
                <span id="test1">用户主页</span>
            </div>
            <div class="index_btn" id="mdpass" onclick="modifyPassword()">
                <i class=" fa fa-unlock"></i>
                <span id="test2">修改密码</span>
            </div>
        </div>
        <div class="mainContent">
            <iframe id="myframe" src="" width="100%" height="100%" frameborder=0></iframe>
        </div>
    </div>
</div>
</body>
</html>
