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
        area: ['400px', '400px'],
        content: 'getUploadPage'
    });
}

function changePass(){
    layer.open({
        type: 2,
        title: '修改密码',
        shadeClose: true,
        shade: 0.8,
        area: ['400px', '400px'],
        content: 'getChangePassPage'
    });
}

$(function () {
    $("#bigAV").click(changeAV)

    $('#changePass').click(changePass)
})