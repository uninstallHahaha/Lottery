<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <!--bootstrap-->
    <link href="js/bootstrap/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap/bootstrap.js"></script>

    <link rel="icon" href="images/buser.ico" type="image/x-icon"/>

    <script src="js/index.js"></script>
    <script src="js/pCenter.js"></script>
    <link href="css/index.css" rel="stylesheet">
    <link href="/css/scroll.css" rel="stylesheet">
    <link href="/css/pCenter.css" rel="stylesheet">

    <title>个人中心</title>
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
                    <a class="navbar-brand" href="/index.jsp">Buser</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/index.jsp">地图</a>
                        </li>
                        <li>
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
                                        <a href="#" id="logoutBtn" onclick="pCenterlogoutBtn()">退出登录</a>
                                    </li>
                                </c:if>
                                <c:if test="${USER_SESSION == null}">
                                    <li>
                                        <a href="#" id="logoutBtn" onclick="pCenterlogoutBtn() style=" display: none;">退出登录</a>
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
                            <div class="col-md-4 column">
                                <div class="panel panel-default pPanel">
                                    <img title="点击切换头像" id="bigAV"
                                         alt="140x140" src=${USER_SESSION.av} class="img-circle"/>
                                    <div class="nick">${USER_SESSION.account}</div>
                                    <button type="button" class="btn btn-default centerBtn">个人中心</button>
                                    <ul class="list-unstyled funUl">
                                        <li class="funLi" id="bindEmail">
                                            绑定邮箱
                                        </li>
                                        <li class="funLi" id="changePass">
                                            修改密码
                                        </li>
                                        <li class="funLi" id="signOut">
                                            注销账号
                                        </li>
                                    </ul>
                                </div>

                            </div>

                            <div class="col-md-8 column">
                                <div class="panel panel-default zanPanel">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">我的赞同</h3>
                                    </div>
                                    <div class="panel-body myFavList">
                                        <ul class="list-group newslist">
                                            <c:if test="${fn:length(supports) == 0}">
                                                <div class="noConter">
                                                    <div class="noCommentDivzan"></div>
                                                    <div class="noCommentTip">暂无赞同</div>
                                                </div>
                                            </c:if>
                                            <c:forEach var="s" items="${supports}">
                                                <li class="list-group-item">
                                                    <a class="zanTitle" href="getNewsDetail?newsId=${ s.newsid }">${s.title}</a>
                                                    <span class="zanTime">发布时间: ${fn:split(s.createtime,'.')[0]}</span>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <div class="panel panel-default zanPanel">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">我的评论</h3>
                                    </div>
                                    <div class="panel-body myFavList">
                                        <ul class="list-group newslist" id="commentListUl">
                                            <c:if test="${fn:length(comments) == 0}">
                                                <div class="noConter">
                                                    <div class="noCommentDiv"></div>
                                                    <div class="noCommentTip">暂无评论</div>
                                                </div>
                                            </c:if>
                                            <c:forEach var="comment" items="${comments}">
                                                <li class="list-group-item" commentid="${comment.id}">
                                                    <div class="commentBody">${comment.content}</div>
                                                    <div class="commentTime">
                                                        <fmt:formatDate value="${comment.createtime}"
                                                                        pattern="yyyy-MM-dd hh:mm:ss"/>
                                                        <a href="#" onclick="outComment('${comment.id}')" class="outBtn">删除</a>
                                                    </div>
                                                    <a class="commentNews"
                                                            href="getNewsDetail?newsId=${ comment.newsid }">
                                                            原文:${comment.title}
                                                    </a>

                                                </li>
                                            </c:forEach>
                                        </ul>
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

</html>