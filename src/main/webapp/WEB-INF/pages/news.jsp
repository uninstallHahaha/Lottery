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

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong
                                    class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Action</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">One more separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" id="showEw">码</a>
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
                                    <li>
                                        <a href="#" id="logoutBtn">退出登录</a>
                                    </li>
                                </c:if>
                                <c:if test="${USER_SESSION == null}">
                                    <li>
                                        <a href="#" id="logoutBtn" style="display: none;">退出登录</a>
                                    </li>
                                </c:if>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
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
                                                    <a class="newsTitle" href="getNewsDetail?newsId=${ news.id }">${ news.title }</a>
                                                    <span class="newsTime">${news.createtime.toLocaleString()}</span>
                                                    <span class="newsDesc">${fn:substring(news.content,0,205).concat('...')}</span>
                                                    <div id="zandiv" class="zandiv">
															<span id="zan">
															<span>赞</span>
															<span id="zancount">
                                                                    ${news.zan}
                                                            </span>
														</span>
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
                                                <h3 class="panel-title">Panel title</h3>
                                            </div>
                                            <div class="panel-body">
                                                Panel content
                                            </div>
                                        </div>
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">Panel title</h3>
                                            </div>
                                            <div class="panel-body">
                                                Panel content
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

<script>

</script>

</html>