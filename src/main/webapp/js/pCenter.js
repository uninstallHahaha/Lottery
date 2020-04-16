//clear session and return map
function pCenterlogoutBtn() {
    $.ajax({
        type: 'POST',
        url: 'logout',
        success: (res) => {
            if (res == '1') {
                layer.msg('已退出登录')
                $('#avImg').attr('src', '/uploads/avatars/default_avatar.png')
                $('#loginBtn').css('display', 'block')
                $('#logoutBtn').css('display', 'none')
                $('#pOut').css('display', 'none')
                //return map
                location.href = "index.jsp"
            }
        }
    });
}

function changeAV() {
    layer.open({
        type: 2,
        title: '上传头像',
        shadeClose: true,
        shade: 0.8,
        shadeClose: false,
        area: ['400px', '400px'],
        content: 'getUploadPage'
    });
}

function changePass() {
    layer.open({
        type: 2,
        title: '修改密码',
        shadeClose: true,
        shade: 0.8,
        area: ['400px', '400px'],
        content: 'getChangePassPage'
    });
}

function outComment(id) {
    layer.confirm('确定删除这条评论?', {
        btn: ['确认', '取消']
    }, function () {
        $.ajax({
            url: 'delComment',
            data: {id: id},
            success: function (res) {
                if (res == 1) {
                    layer.msg('删除成功', {icon: 1})
                    $("[commentid=" + id + "]").remove()
                    if ($('#commentListUl').children().length == 0) {
                        let noDom = "<div class=\"noConter\">\n" +
                            "<div class=\"noCommentDiv\"></div>\n" +
                            "<div class=\"noCommentTip\">暂无评论</div>\n" +
                            "</div>"
                        $('#commentListUl').append(noDom)
                    }
                }
            }
        })
    })
}

$(function () {
    $("#bigAV").click(changeAV)

    $('#changePass').click(changePass)

    $('#bindEmail').mouseover(function () {
        layer.tips('绑定邮箱后可使用邮箱找回密码', '#bindEmail')
    })
    $('#bindEmail').click(function () {
        layer.open({
            title:'绑定邮箱',
            type: 2,
            // btn: ['确定', '取消'],
            area: ['420px', '240px'], //宽高
            content: 'getEmailPage',
        });
    })

    $("#signOut").click(function () {

        layer.prompt({title: '输入密码以注销账户', formType: 1}, function (pass, index) {
            //
            $.ajax({
                url: 'signout',
                data: {pass: pass},
                success: function (res) {
                    if (res.stat == 1) {
                        layer.msg('注销成功', {icon: 1})
                        location.href = "index.jsp"
                    } else if (res.stat == 0) {
                        layer.msg(res.data, {icon: 2})
                    }
                }
            })
            layer.close(index);
        });
    })
})