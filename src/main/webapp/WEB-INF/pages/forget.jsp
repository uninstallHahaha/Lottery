<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page isELIgnored="false" %> <%--开启el--%>
<html>
<head>
    <title>Title</title>
    <!--jquery-->
    <script src="js/jq/jquery.min.js"></script>
    <script src="../layer/layer.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="js/login.js"></script>

    <style type="text/css">
        .forgetTip{
            color: #ccc;
            font-size: 10px;
        }
        .forgetCon{
            padding: 12px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100%;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row clearfix">

        <div class="col-md-12 column">

            <div class="forgetCon">
                <input type="text" class="form-control"
                       placeholder="请输入账号或邮箱"
                       id="forgetAccount" name="forgetAccount"/>
                <span class="forgetTip">提示:请确保您的账号已经绑定邮箱,否则无法找回您的密码</span>
                <button id="forgetBtn" onclick="sendForget()" type="button"
                        class="btn btn-default btn-block btn-primary">
                    确定
                </button>
            <button id="cancelForget" onclick="cancelForget()" type="button"
                    class="btn btn-default btn-block">
                取消
            </button>
            </div>
        </div>
    </div>
</div>

<script>


    function cancelForget() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }

    function sendForget() {
        //发送邮件
        layer.load(1, {
            shade: 0.2
        })
        let forgetAc = $('#forgetAccount').val()
        if (forgetAc == "") {
            layer.msg('请输入正确的账号或邮箱地址')
        } else {
            $.ajax({
                url: 'sendForget',
                data: {acc: forgetAc},
                success: function (res) {
                    layer.closeAll('loading');
                    if (res.stat == 1) {
                        layer.msg('我们已经向您的邮箱发送了一封邮件,请注意查收')
                    } else {
                        layer.msg(res.data)
                    }
                }
                ,
                error: function () {
                    layer.closeAll('loading');
                    layer.msg('系统异常,请稍后再试')
                }
            })
        }
    }


</script>


</body>
</html>
