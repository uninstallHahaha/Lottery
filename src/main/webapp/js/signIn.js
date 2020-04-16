function signIn() {
    let ac = $('#inputEmail3').val()
    let ps = $('#inputPassword3').val()
    let reps = $('#rePass').val()
    if(ac == "" || ps == ""){
        layer.msg('请输入账号和密码')
        return
    }
    if(ps.length < 8){
        layer.msg('密码不能小于8位')
        return
    }
    if(ps != reps){
        layer.msg('两次输入的密码不一致')
        return
    }
    $.ajax({
        type: 'POST',
        url: 'signIn',
        data: {
            'account': ac,
            'pass': ps,
        },
        success: (res) => {
            if(res.stat==1){
                //自动登录
                $.ajax({
                    type: 'POST',
                    url: 'login',
                    data: {
                        'account': ac,
                        'password': ps,
                    },
                    success: (res) => {
                        if(res!=""){
                            parent.layer.msg("注册成功, 已自动登录",{icon:1})
                            parent.$('#avImg').attr('src',res.av)
                            parent.$('#loginBtn').css('display','none')
                            parent.$('#logoutBtn').css('display','block')
                            parent.$('#pCenter').css('display','block')
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        }else{
                            parent.layer.msg("注册成功",{icon:1})
                            location.href="getLoginPage"
                        }
                    }
                });
            }else{
                layer.msg(res.data,{'icon':2})
            }
        }
    });
}


$(function () {
    $('#signIn').click(signIn)
})