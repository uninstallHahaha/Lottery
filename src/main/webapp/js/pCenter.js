//clear session and return map
function pCenterlogoutBtn(){
    $.ajax({
        type: 'POST',
        url: 'logout',
        success: (res) => {
            if(res=='1'){
                layer.msg('已退出登录')
                $('#avImg').attr('src','/uploads/avatars/default_avatar.png')
                $('#loginBtn').css('display','block')
                $('#logoutBtn').css('display','none')
                $('#pOut').css('display','none')
                //return map
                location.href="index.jsp"
            }
        }
    });
}