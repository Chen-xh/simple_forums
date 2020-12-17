<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>home</title>

    <link rel="stylesheet" type="text/css" href="css/my.css"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="./js/http_cdn.staticfile.org_jquery_1.10.2_jquery.js"></script>
    <script src="js/jq.cookie.js"></script>
</head>
<SCRIPT>
    let url1 = "/ssm9/findAllComment";
    let url2 = "/ssm9/addComment";
    let uid;
    let tid;
    let  topic;

    $(function () {
        topic=$.cookie("item").split("&chen&")
        tid=topic[0];
        uid=${sessionScope.user.id}
        $("#title").text(topic[1])
        $("#message").text(topic[2])
        $("#author").text("Author : "+topic[3])
        getData();
    })

    function getData() {
        $.ajax({
            type: "GET",
            url: url1+"?tid="+tid,
            success: function (result) {
                let list = result.data;
                if (list != null) {
                    let comments_contain = $("#comments_contain")
                    comments_contain.empty();
                    for (let i = 0; i <  result.data.length; i++) {
                        let message = $("<span></span>").append(list[i].message )
                        let author = $("<span></span>").append(list[i].username+ " : ")
                        let item = $(" <div class='comment' ></div>").append(author,message);
                        comments_contain.append(item)
                    }
                }
            },
            error: function (result) {
                console.log(tid)
                alert("请求失败!请重新尝试!");
            }
        });
    }
    function sendData(content) {
        $.ajax({
            type: "POST",
            url: url2,
            dataType:"json",
            data:{ "uid":uid,"message":content,"tid":tid},
            success: function (result) {
                //刷新页面
                window.location.reload();
            },
            error: function (result) {
                alert("请求失败!请重新尝试!");
            }
        });
    }
    function allTopic() {
        window.location.href = 'home.jsp';
    }

    function myTopic() {
        if (${sessionScope.user!=null}) {
            window.location.href = 'home_my_topic.jsp';
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

    function addComment() {
        if (${sessionScope.user!=null}) {
            let content=$("#content").val();
            sendData(content)
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
               <h4 id="title"></h4>
                <p id="message"></p>
                <p id="author" style="color: #cccccc"></p>
            </div>
            <label>
                <textarea rows="8" cols="40" id="content" class="input_text2" style="width: 100%;height: 100px">评论一下</textarea>
            </label>
            <button class="form_btn2" style="float: right;" onclick="addComment()">我来评论</button>
            <div style="clear:both;height: 20px"></div>
            <div id="comments_contain">
<%--                <div class="comment" >--%>
<%--                    <span>chen:</span>--%>
<%--                    <span>efsafhaook!!@@</span>--%>
<%--                </div>--%>
            </div>

        </div>
    </div>
</div>
</body>
</html>