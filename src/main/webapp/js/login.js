function login() {
    let ac = $('#inputEmail3').val()
    let ps = $('#inputPassword3').val()
    let rem = $('#remember').val()
    $.ajax({
        type: 'POST',
        url: 'login',
        data: {
            'account': ac,
            'password': ps,
            'remember': rem
        },
        success: (res) => {
            if(res!=""){
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
                parent.layer.msg("登录成功",{'icon':1})
                parent.$('#avImg').attr('src',res.av)
                parent.$('#loginBtn').css('display','none')
                parent.$('#logoutBtn').css('display','block')
                parent.$('#pCenter').css('display','block')
            }else{
                layer.msg("登录失败,请检查账号密码",{'icon':2})
            }
        }
    });
}


$(function () {
    $('#loginBtn').click(login)
})