<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="css/index.css" rel="stylesheet">

    <title></title>
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
                    <a class="navbar-brand" href="index.jsp">Buser</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="index.jsp">地图</a>
                        </li>
                        <li>
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
                    <div class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" value="天安门" class="form-control" id="poiInput"/>
                        </div>
                        <button class="btn btn-default" onclick="placeSearch()">搜索</button>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">码</a>
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
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div id="container">
                    </div>

                    <div id="search" class="searchDiv">
                        <div class="inputDiv">
                            <input type="text" name="" id="start" value="" placeholder="请输入起点" class="poiin"/><br>
                            <input type="text" name="" id="end" value="" placeholder="请输入终点" class="poiin poiinend"/>
                        </div>
                        <div class="searchBtn" onclick="routePlan()">
                            <!--<div class="searchBtn" onclick="fadeInn()">-->
                            <a href="#"> 查询 </a>
                        </div>
                    </div>

                    <div id="planPoi">
                        <ul id="waitPOI">

                        </ul>
                    </div>

                    <div class="coverCopyRight ">@ 2020 Aaidu.com</div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    //加载地图
    var map = new BMap.Map("container", {
        enableMapClick: false
    });
    map.centerAndZoom(new BMap.Point(116.404, 39.915), 14);

    //设置地图可缩放
    map.centerAndZoom(new BMap.Point(116.4035, 39.915), 8);
    setTimeout(function () {
        map.setZoom(14);
    }, 100); //2秒后放大到14级
    map.enableScrollWheelZoom(true);
    //定位控件
    var opts = {
        offset: new BMap.Size(20, 90),
    }
    var geolocationControl = new BMap.GeolocationControl(opts);
    geolocationControl.addEventListener("locationSuccess", function (e) {
        // 定位成功事件
        var address = '';
        address += e.addressComponent.province;
        address += e.addressComponent.city;
        address += e.addressComponent.district;
        address += e.addressComponent.street;
        address += e.addressComponent.streetNumber;
        alert("当前定位地址为：" + address);
    });
    geolocationControl.addEventListener("locationError", function (e) {
        // 定位失败事件
        alert(e.message);
    });
    map.addControl(geolocationControl);
    //缩放控件
    var top_left_navigation = new BMap.NavigationControl({
        anchor: BMAP_ANCHOR_TOP_RIGHT
    });
    map.addControl(top_left_navigation);

    //标注点
    var marker = new BMap.Marker(new BMap.Point(116.4035, 39.915)); // 创建标注
    map.addOverlay(marker); // 将标注添加到地图中
    marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画

    //点击监听
    map.addEventListener("click", function (e) {
        console.log("点击了经纬度: " + e.point.lng + ", " + e.point.lat);
    });

</script>

</html>