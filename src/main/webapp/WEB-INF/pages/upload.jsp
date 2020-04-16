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
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="css/upload.css"
          rel="stylesheet">
    <script src="js/upload.js"></script>
</head>
<body>

<div class="container">
    <div class="row clearfix upCon">
        <div class="imgDiv">
            <img id="preview_photo" class="upShowImg" src="" width="200px" height="200px">
        </div>
        <div id="picName"></div>
        <a href="javascript:void(0)" onclick="uploadPhoto()" class="chooseBtn">选择图片</a>
        <a href="javascript:void(0)" onclick="doAVUpload()" class="uploadBtn">上传图片</a>
        <input type="file" id="photoFile" style="display: none;" onchange="showPicName()">
    </div>
</div>


</body>
</html>
