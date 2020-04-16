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
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="js/CPass.js"></script>
    <link href="css/CPass.css" rel="stylesheet">

</head>
<body>

<div class="container">
    <div class="row clearfix">
        <form class="form-horizontal formChange" role="form" method="post" action="modPass">
            <div class="form-group">
                <label class="col-sm-2 control-label">原密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control " id="oldPass"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">新密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control " id="newPass"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">确认新密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control " id="reNewPass"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-default btn-primary" id="subModPass">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
