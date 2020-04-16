<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <title>Buser</title>
    <!--百度地图-->
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=3.0&ak=lG1VWYp7csmOHn3Au6WRSrLKlGaSXIk3"></script>
    <!--jquery-->
    <script src="js/jq/jquery.min.js"></script>
    <script src="layer/layer.js"></script>
    <script src="js/index.js"></script>

    <!--bootstrap-->
    <link href="js/bootstrap/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap/bootstrap.js"></script>

    <link rel="icon" href="images/buser.ico" type="image/x-icon"/>

    <link href="css/scroll.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">

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
                        <%--                        <li class="dropdown">--%>
                        <%--                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong--%>
                        <%--                                    class="caret"></strong></a>--%>
                        <%--                            <ul class="dropdown-menu">--%>
                        <%--                                <li>--%>
                        <%--                                    <a href="#">Action</a>--%>
                        <%--                                </li>--%>
                        <%--                                <li>--%>
                        <%--                                    <a href="#">Another action</a>--%>
                        <%--                                </li>--%>
                        <%--                                <li>--%>
                        <%--                                    <a href="#">Something else here</a>--%>
                        <%--                                </li>--%>
                        <%--                                <li class="divider">--%>
                        <%--                                </li>--%>
                        <%--                                <li>--%>
                        <%--                                    <a href="#">Separated link</a>--%>
                        <%--                                </li>--%>
                        <%--                                <li class="divider">--%>
                        <%--                                </li>--%>
                        <%--                                <li>--%>
                        <%--                                    <a href="#">One more separated link</a>--%>
                        <%--                                </li>--%>
                        <%--                            </ul>--%>
                        <%--                        </li>--%>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <div class="navbar-form navbar-left">
                                <div class="form-group">
                                    <input type="text" placeholder="输入公交路线以查询" class="form-control" id="poiInput"/>
                                </div>
                                <button class="btn btn-default" onclick="busSearch()">搜索</button>
                            </div>
                        </li>
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
                        <div id="route_policy" class="route_policy">
                            <div class="rowWay">
                                <div val="0" class="way act">最少时间</div>
                                <div val="1" class="way">最少换乘</div>
                            </div>
                            <div class="rowWay">
                                <div val="2" class="way">最少步行</div>
                                <div val="3" class="way">不乘地铁</div>
                            </div>
                        </div>
                    </div>

                    <div id="planPoi">
                        <ul id="waitPOI">

                        </ul>
                    </div>

                    <div class="coverCopyRight ">@ 2020 Buser.com</div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<div id="r-result"></div>

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


    //公交线路查询器
    var busline = new BMap.BusLineSearch(map, {
        renderOptions: {map: map, panel: "r-result"},
        onGetBusListComplete: function (result) {
            if (result) {
                var fstLine = result.getBusListItem(0);//获取第一个公交列表显示到map上
                busline.getBusLine(fstLine);
            }
        }
    });

</script>

</html>