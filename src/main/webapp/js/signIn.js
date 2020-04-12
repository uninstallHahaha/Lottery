function signIn() {
    let ac = $('#inputEmail3').val()
    let ps = $('#inputPassword3').val()
    $.ajax({
        type: 'POST',
        url: 'signIn',
        data: {
            'account': ac,
            'pass': ps,
        },
        success: (res) => {
            if(res==1){
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
                layer.msg("注册失败, 请稍后再试",{'icon':2})
            }
        }
    });
}


$(function () {
    $('#signIn').click(signIn)
})