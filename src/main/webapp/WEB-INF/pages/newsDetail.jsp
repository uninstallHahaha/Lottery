<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page isELIgnored="false" %> <%--开启el--%>
<html>

<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <!--百度地图-->
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=3.0&ak=lG1VWYp7csmOHn3Au6WRSrLKlGaSXIk3"></script>
    <!--jquery-->
    <script src="js/jq/jquery.min.js"></script>
    <script src="layer/layer.js"></script>
    <!--editer-->
    <script src="libjs/wangEditor.js"></script>

    <!--bootstrap-->
    <link href="js/bootstrap/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap/bootstrap.js"></script>

    <link rel="icon" href="images/buser.ico" type="image/x-icon"/>

    <link href="css/scroll.css" rel="stylesheet">
    <script src="js/index.js"></script>
    <link href="css/index.css" rel="stylesheet">
    <link href="css/newsDetail.css" rel="stylesheet">
    <script src="js/newsDetail.js"></script>
    <script src="js/news.js"></script>


    <title>${news.title}</title>
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation" style="margin: 0px;">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1"><span
                            class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                            class="icon-bar"></span><span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="../index.jsp">Buser</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="index.jsp">地图</a>
                        </li>
                        <li class="active">
                            <a href="getNewsPage">新闻</a>
                        </li>

                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" id="showEw">
                                <svg class="Zi Zi--Share Button-zi" fill="currentColor" viewBox="0 0 24 24" width="1.2em" height="1.2em"><path d="M2.931 7.89c-1.067.24-1.275 1.669-.318 2.207l5.277 2.908 8.168-4.776c.25-.127.477.198.273.39L9.05 14.66l.927 5.953c.18 1.084 1.593 1.376 2.182.456l9.644-15.242c.584-.892-.212-2.029-1.234-1.796L2.93 7.89z" fill-rule="evenodd"></path></svg>
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="pages/pCenter.jsp" class="dropdown-toggle" data-toggle="dropdown">
                                <img class="avImg" id="avImg"
                                     src=${USER_SESSION == null? '/uploads/avatars/default_avatar.png':USER_SESSION.av} alt="">
                                我的
                                <strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <c:if test="${USER_SESSION == null}">
                                    <li>
                                        <a href="#" id="loginBtn">登录</a>
                                    </li>
                                </c:if>
                                <c:if test="${USER_SESSION != null}">
                                    <li>
                                        <a href="#" id="loginBtn" style="display: none;">登录</a>
                                    </li>
                                </c:if>
                                <c:if test="${USER_SESSION != null}">
                                    <li>
                                        <a id="pCenter" href="toPCenter">个人中心</a>
                                    </li>
                                </c:if>
                                <c:if test="${USER_SESSION == null}">
                                    <li>
                                        <a id="pCenter" href="toPCenter" style="display: none;">个人中心</a>
                                    </li>
                                </c:if>
                                <c:if test="${USER_SESSION != null}">
                                    <li class="divider">
                                    </li>
                                    <li>
                                        <a href="#" id="logoutBtn">退出登录</a>
                                    </li>
                                </c:if>
                                <c:if test="${USER_SESSION == null}">
                                    <li>
                                        <a href="#" id="logoutBtn" style="display: none;">退出登录</a>
                                    </li>
                                </c:if>

                            </ul>
                        </li>
                    </ul>
                </div>

            </nav>
            <div class="row clearfix" style="    display: flex;justify-content : center;">
                <div class="col-md-12 column" style="width: 75%;;">

                    <div class="col-md-12 column">
                        <div class="row clearfix main">
                            <div class="col-md-8 column ">
                                <form action="getNewsPage" class="headFrom">
                                    <button type="submit" class="btn btn-default noDe">
                                        <返回新闻列表
                                    </button>
                                    <div id="zandiv" class="zandiv">

                                        <c:if test="${news.ifSupport}">
                                            <span id="zan" class="zan zaned" newsid=${news.id}>
                                                            已赞同
                                                            ${news.zan}
                                            </span>
                                        </c:if>
                                        <c:if test="${!(news.ifSupport)}">
                                             <span id="zan" class="zan" newsid=${news.id}>
                                                            赞同
                                                            ${news.zan}
                                             </span>
                                        </c:if>

                                    </div>
                                </form>
                                <div class="panel panel-default newslistDiv newsCon">
                                    <div class="panel-body">
                                        <h3 class="newsTitle">${news.title}</h3>
                                        <span class="newsTime">
                                            ${news.createtime.toLocaleString()}
                                        </span>
                                        <span class="newsDesc">
                                            ${news.content}
                                        </span>

                                    </div>

                                </div>

                            </div>
                            <div class="col-md-4 column">
                                <div class="row clearfix">
                                    <div class="col-md-12 column">
                                        <div class="panel panel-default comPanel">
                                            <div class="panel-heading comheading">
                                                <h3 class="panel-title" style="display: inline-block;">评论 &nbsp;
                                                    <i id="commentSize">${fn:length(comments)}</i>
                                                </h3>
                                                <div class="addComBtn" id="addComBtn" title="发表评论">+</div>
                                            </div>
                                            <div class="panel-body commentList">
                                                <ul class="list-group newslist" id="commentsUL">
                                                    <c:if test="${fn:length(comments) == 0}">
                                                        <div class="noConter" id="noConter">
                                                            <div class="noCommentDiv"></div>
                                                            <div class="noCommentTip">暂无评论</div>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${fn:length(comments) != 0}">
                                                    <c:forEach items="${comments}" var="comment">
                                                        <li class="list-group-item commentLI">
                                                            <image alt="头像"
                                                                   src="${comment.av}"
                                                                   class="commentAv"></image>
                                                            <div class="comConer">
                                                                <span class="comUser">${comment.account}</span>
                                                                <span class="comCon" title="${comment.content}">${comment.content}</span>
                                                                <span class="comTime">${comment.createtime.toLocaleString()}</span>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                    </c:if>
                                                </ul>
                                            </div>
                                        </div>

                                        <div class="btn-group btn-group-md">
                                            <button class="btn btn-default" type="button"><em
                                                    class="glyphicon glyphicon-align-left"></em> 左
                                            </button>
                                            <button class="btn btn-default" type="button"><em
                                                    class="glyphicon glyphicon-align-center"></em> 中
                                            </button>
                                            <button class="btn btn-default" type="button"><em
                                                    class="glyphicon glyphicon-align-right"></em> 右
                                            </button>
                                            <button class="btn btn-default" type="button"><em
                                                    class="glyphicon glyphicon-align-justify"></em> 全
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="coverCopyRight">@ 2020 Aaidu.com</div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<div style="display: none;" id="nid">${news.id}</div>

<div id="editor">
</div>

</html>