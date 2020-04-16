<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page isELIgnored="false" %> <%--开启el--%>

<html>

<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <title>公交路线规划</title>
    <!--百度地图-->
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=3.0&ak=lG1VWYp7csmOHn3Au6WRSrLKlGaSXIk3"></script>
    <!--jquery-->
    <script src="js/jq/jquery.min.js"></script>
    <script src="layer/layer.js"></script>
    <script src="js/index.js"></script>

    <!--bootstrap-->
    <%--    <link href="js/bootstrap/bootstrap.css" rel="stylesheet">--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap/bootstrap.js"></script>

    <link rel="icon" href="images/buser.ico" type="image/x-icon"/>

    <link href="css/index.css" rel="stylesheet">
    <link href="css/news.css" rel="stylesheet">
    <link href="css/scroll.css" rel="stylesheet">
    <script src="js/news.js"></script>
    <script src="js/utils.js"></script>


    <title>新闻</title>
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
                            <a href="../index.jsp">地图</a>
                        </li>
                        <li class="active">
                            <a href="getNewsPage">新闻</a>
                        </li>

                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" id="showEw">
                                <svg class="Zi Zi--Share Button-zi" fill="currentColor" viewBox="0 0 24 24"
                                     width="1.2em" height="1.2em">
                                    <path d="M2.931 7.89c-1.067.24-1.275 1.669-.318 2.207l5.277 2.908 8.168-4.776c.25-.127.477.198.273.39L9.05 14.66l.927 5.953c.18 1.084 1.593 1.376 2.182.456l9.644-15.242c.584-.892-.212-2.029-1.234-1.796L2.93 7.89z"
                                          fill-rule="evenodd"></path>
                                </svg>
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

                                <div class="panel panel-default newslistDiv" id="newslistDiv">

                                    <div class="panel-body">
                                        <ul class="list-group newslist" id="newslistUl">
                                            <c:forEach items="${newsList}" var="news">
                                                <li class="list-group-item">
                                                    <a class="newsTitle"
                                                       href="getNewsDetail?newsId=${ news.id }">${ news.title }</a>
                                                    <span class="newsTime">${news.createtime.toLocaleString()}</span>
                                                    <span class="newsDesc">${fn:substring(news.content,0,205).concat('...')}</span>
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
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>

                                </div>

                                <ul class="pagination pagination-sm">
                                    <li>
                                        <a href="#">Prev</a>
                                    </li>
                                    <li>
                                        <a href="#">1</a>
                                    </li>
                                    <li>
                                        <a href="#">2</a>
                                    </li>
                                    <li>
                                        <a href="#">3</a>
                                    </li>
                                    <li>
                                        <a href="#">4</a>
                                    </li>
                                    <li>
                                        <a href="#">5</a>
                                    </li>
                                    <li>
                                        <a href="#">Next</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-md-4 column">
                                <div class="row clearfix">
                                    <div class="col-md-12 column">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">新闻热榜</h3>
                                            </div>
                                            <div class="panel-body">
                                                <ul class="list-group newslist">
                                                    <c:forEach var="tn" items="${topNews}" varStatus="state">
                                                        <li class="list-group-item topLi">
                                                              <div class="topNum">  ${state.index+1}.</div>
                                                            <a class="zanTitle"
                                                               href="getNewsDetail?newsId=${ tn.id }">${tn.title}</a>
                                                            <span class="topZan">${tn.zan}</span>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="coverCopyRight">@ 2020 Buser.com</div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script>

</script>

</html>