<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>regedit</title>
    <link rel="stylesheet" type="text/css" href="css/my.css"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="./js/http_cdn.staticfile.org_jquery_1.10.2_jquery.js"></script>
</head>
<script type="text/javascript">
    $(function(){
        let username = false;
        let password = false;
        let passwordSure = false;

        $("#username").keypress(function(){
            if($(this).val()==""){
                // $("#namecheck").css("color","red").html("X");
                username = false;
            }else{
                // $("#namecheck").css("color","green").html("√");
                username = true;
            }
        });
        $("#username").blur(function(){
            if($(this).val()==""){
                // $("#namecheck").css("color","red").html("X");
                username = false;
            }else{
                // $("#namecheck").css("color","green").html("√");
                username = true;
            }
        });

        $("#password").blur(function(){
            if($(this).val()==""){
                // $("#checkpassword").css("color","red").html("X");
                password= false;
            }else{
                // $("#checkpassword").css("color","green").html("√");
                password = true;
            }
        });
        $("#checkPassword").blur(function(){
            if($(this).val()==""||$(this).val()!=$("#password").val()){
                // $("#checkpassword2").css("color","red").html("X");
                passwordSure = false;
            }else{
                // $("#checkpassword2").css("color","green").html("√");
                passwordSure = true;
            }
        });
        $(":submit").click(function(){
            if(username==false||password==false||passwordSure==false){
                alert("请核对完整信息");
                return false;
            }
        })
    });
    function loginBtn() {
        window.location.href = '/ssm9/login.jsp';
    }
</script>
<body class="mui-content" >
<canvas id="cas" ></canvas>
<div class="regedit_container" >
    <div class="regedit_box">
        <img class="logo" src="images/logo.jpg">
        <div>
            <span style="text-align: right;color: darkgray" onclick="loginBtn()">登录</span>
            <span style="text-align:left;border-bottom: 5px  solid  #3D84FF ">注册</span>
        </div>

        <HR color=#d5caca SIZE=1>
        <!-- 登录表单区域 -->
        <form action="regedit" method="post">
            <div style="position: relative">
                <label for="username"></label>
                <i class="icon-input fa fa-user"></i>
                <input class="input_text" type="text" id="username" name="username" placeholder="请输入用户名"/>
            </div>
            <div style="position: relative">
                <label for="password"></label>
                <i class="icon-input fa fa-lock"></i>
                <input class="input_text " type="password" name="password" placeholder="请输入密码" id="password"/>
            </div>
            <div style="position: relative">
                <label for="checkPassword"></label>
                <i class="icon-input fa fa-check-square"></i>
                <input class="input_text " type="password" name="checkPassword" placeholder="请再次输入密码" id="checkPassword"/>
            </div>
            <p class="error"> ${message}</p>
            <div class="btn">
                <button type="submit" class="form_btn "  >注册</button>
            </div>
            <div class="btn">
                <button type="reset" class="form_btn">重置</button>
            </div>
        </form>
    </div>
</div>
</body>
<script src="./js/canvas.js"></script>
</html>