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
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <!--layer-->
    <script src="layer/layer.js"></script>
    <!--editer-->
    <script src="libjs/wangEditor.js"></script>
    <!--
        作者：offline
        时间：2020-04-10
        描述：owner
    -->
    <script src="js/newsDetail.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="css/newsDetail.css" rel="stylesheet">

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
                            <a href="../index.jsp">地图</a>
                        </li>
                        <li class="active">
                            <a href="news.jsp">新闻</a>
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
                            <a href="#">Link</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">我的<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="pCenter.jsp">个人中心</a>
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
                                    <button type="submit" class="btn btn-link btn-default noDe">
                                        <返回新闻列表
                                    </button>

                                    <div id="zandiv" class="zandiv">
										<span id="zan">
											<span>赞</span>
											<span id="zancount">
                                                ${news.zan}
                                            </span>
										</span>
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
                                        <div class="panel panel-default">
                                            <div class="panel-heading comheading">
                                                <h3 class="panel-title" style="display: inline-block;">评论</h3>
                                                <div class="addComBtn" id="addComBtn" title="发表评论">+</div>
                                            </div>
                                            <div class="panel-body commentList">
                                                <ul class="list-group newslist">
                                                    <c:forEach items="${comments}" var="comment">
                                                        <li class="list-group-item commentLI">
                                                            <image alt="头像" src="uploads/avatars/default_avatar.png"
                                                                   class="commentAv"></image>
                                                            <div class="comConer">
                                                                <span class="comCon">${comment.content}</span>
                                                                <span class="comTime">${comment.createtime.toLocaleString()}</span>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
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