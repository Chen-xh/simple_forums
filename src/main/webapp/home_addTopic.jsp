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
    let curPage;
    let totalPage;
    let url1 = "/ssm9/addTopic";
    let uid = ${sessionScope.user.id};

    function sendData(title, content) {
        $.ajax({
            type: "POST",
            url: url1,
            dataType:"json",
            data:{ "title":title,"message":content,"uid":uid},
            success: function (result) {
                window.location.href = '/ssm9/home.jsp';
            },
            error: function (result) {
                // alert(result+"sss");
                alert("请求失败!请重新尝试!");
            }
        });
    }

    function allTopic() {
        window.location.href = '/ssm9/home.jsp';
    }

    function myTopic() {
        if (${sessionScope.user!=null}) {
            window.location.href = '/ssm9/home_my_topic.jsp';
        } else {
            alert("请先登录！")
        }
    }

    function myComment() {
        if (${sessionScope.user!=null}) {
            window.location.href = '/ssm9/home_my_comment.jsp';
        } else {
            alert("请先登录！")
        }
    }

    function commit() {

        if (${sessionScope.user!=null}) {
            console.log($("#title").val())
            sendData($("#title").val(), $("#content").val())
        } else {
            alert("请先登录！")
        }
    }
</SCRIPT>
<body>
<div class="user_container">
    <div class="topic_box">
        <h2>Home</h2>
        <div>
            <div style="float:left;">
                <span class="home_title" onclick="allTopic()">所有帖子</span>
                <span class="home_title" onclick="myTopic()">我的帖子</span>
                <span class="home_title" onclick="myComment()">我的留言</span>
            </div>

        </div>
        <div style="clear:both;"></div>
        <HR color=#d5caca SIZE=1 style="margin-top: 10px">
        <div style="width: 60%;">
            <div id="topic_contain">
                <label for="title">标题</label><br>
                <input type="text" id="title" class="input_text2" style="width: 100%">
                <label>内容</label>
                <label>
                    <textarea rows="8" cols="40" id="content" class="input_text2" style="width: 100%;height: 250px">分享一下你的精彩</textarea>
                </label>
            </div>
            <div style="text-align: center;">
                <button class="form_btn3" onclick="commit()">发布</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>