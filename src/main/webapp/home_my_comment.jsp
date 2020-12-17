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
    let url1 = "/ssm9/findCommentByUid"
    let url2 = "/ssm9/deleteComment"
    let list;
    let uid=${sessionScope.user.id}
    $(function () {
        getData()
    })

    function getData() {
        $.ajax({
            type: "GET",
            url: url1 +"?uid="+ uid,
            success: function (result) {
                list = result.data;
                if (list != null) {
                    let comments_contain = $("#comments_contain")
                    comments_contain.empty();
                    for (let i = 0; i < list.length; i++) {
                        let message = $("<span></span>").append(list[i].message )
                        let author = $("<span></span>").append(list[i].username+ " : ")
                        let toDelete = $("<span class=\"topic_item_r\"  onclick='toDelete(" + i + ")'>删除</span>")
                        let item = $(" <div class='comment' ></div>").append(author,message,toDelete);
                        comments_contain.append(item)
                    }
                }
            },
            error: function (result) {
                alert("请求失败!请重新尝试!");
            }
        });
    }
    function toDelete(i) {
        $.ajax({
            type: "GET",
            url: url2 +"?cid="+list[i].cid,
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
        <div style="clear:both;"></div>
        <HR color=#d5caca SIZE=1 style="margin-top: 10px">
        <div style="width: 60%;">
            <div id="comments_contain">
            </div>
        </div>
    </div>
</div>
</body>
</html>