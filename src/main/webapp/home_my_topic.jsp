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
    let list;
    let curPage;
    let totalPage;
    let url1 = "/ssm9/findTopicByUid";
    let url2 = "/ssm9/deleteTopic"
    let uid = ${sessionScope.user.id}
        $(function () {
            getData(1)
            curPage = 1;
        })

    function getData(size) {
        $.ajax({
            type: "GET",
            url: url1 + "?page=" + size + "&uid=" + uid,
            success: function (result) {
                // console.log(result)
                 list = result.data.list;
                totalPage = result.data.totalPage;
                if (list != null) {
                    let topic_contain = $("#topic_contain")
                    topic_contain.empty();
                    for (let i = 0; i < list.length; i++) {
                        let title = $("<div ></div>").append(list[i].title)
                        let message = $("<span class=\"topic_item_l\"></span>").append(list[i].message.substring(0, 35) + "...")
                        let toDelete = $("<span class=\"topic_item_r\"  onclick='toDelete(" + i + ")'>删除</span>")
                        let item = $(" <div class='topic_item'></div>").append(title, message, toDelete);
                        topic_contain.append(item)
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
            url: url2 +"?tid="+list[i].tid,
            success: function (result) {
                //刷新页面
                window.location.reload();
            },
            error: function (result) {
                alert("请求失败!请重新尝试!");
            }
        });
    }

    function toFirst() {
        curPage = 1
        getData(curPage)
    }

    function toEnd() {
        curPage = totalPage
        getData(totalPage)
    }

    function toLast() {
        if (curPage != 1) {
            curPage--
            getData(curPage)
        }
    }

    function toNext() {
        if (curPage != totalPage) {
            curPage++
            getData(curPage)
        }
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

    function addTopic() {
        if (${sessionScope.user!=null}) {
            window.location.href = '/ssm9/home_addTopic.jsp';
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
                <label class="home_title" for="select" style="margin-left: 40px">查询贴子</label>
                <input class="input_text2" style="margin-bottom:0" type="text" id="select" placeholder="输入标题"/>
                <button class="form_btn3">查询</button>
            </div>
            <div style="float: right;">
                <button class="form_btn2" style="float: right;" onclick="addTopic()">我来发布</button>
            </div>
        </div>
        <div style="clear:both;"></div>
        <HR color=#d5caca SIZE=1 style="margin-top: 10px">
        <div style="width: 60%;">
            <div id="topic_contain">
                <%--            <div class="topic_item">--%>
                <%--                <div >title</div>--%>
                <%--                <span class="topic_item_l">message</span>--%>
                <%--                <span class="topic_item_r" >author</span>--%>
                <%--            </div>--%>
            </div>
            <div style="text-align: center;">
                <button class="form_btn3" onclick="toFirst()">首页</button>
                <button class="form_btn3" onclick="toLast()" id="toLast">上一页</button>
                <button class="form_btn3" onclick="toNext()" id="toNext">下一页</button>
                <button class="form_btn3" onclick="toEnd()">末尾</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>