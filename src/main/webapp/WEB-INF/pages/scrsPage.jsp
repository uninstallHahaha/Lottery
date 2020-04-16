<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page isELIgnored="false" %> <%--开启el--%>
<html>
<head>
    <title>Title</title>
    <!--jquery-->
    <script src="js/jq/jquery.min.js"></script>
    <script src="layer/layer.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
          rel="stylesheet">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js">
    </script>

    <link href="/css/scroll.css" rel="stylesheet">
    <link href="/css/scrsPage.css" rel="stylesheet">

    <script src="js/scrsPage.js"></script>


</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="list-unstyled" id="scrsUl">
                <c:if test="${fn:length(scrs)==0}">
                    <div class="noConter">
                        <div class="noCommentDivzan"></div>
                        <div class="noCommentTip">暂无草稿</div>
                    </div>
                </c:if>
                <c:forEach items="${scrs}" var="s">
                    <li class="scrLi" newsid="${s.id}">
                            ${s.title}
                        <div>
                            <button onclick="delScr('${s.id}')" class="outBtn">删除</button>
                            <button class="loadSrcBtn outBtn" >载入</button>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
