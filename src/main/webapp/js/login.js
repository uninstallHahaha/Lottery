function login() {
    let ac = $('#inputEmail3').val()
    let ps = $('#inputPassword3').val()
    let rem = $('#remember').val()
    if(ac == "" || ps == ""){
        layer.msg('请输入账号和密码')
        return
    }
    layer.load(1, {
        shade: 0.2
    });
    $.ajax({
        type: 'POST',
        url: 'login',
        data: {
            'account': ac,
            'password': ps,
            'remember': rem
        },
        success: (res) => {
            layer.closeAll('loading');
            if (res != "") {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
                parent.layer.msg("登录成功", {'icon': 1})
                parent.$('#avImg').attr('src', res.av)
                parent.$('#loginBtn').css('display', 'none')
                parent.$('#logoutBtn').css('display', 'block')
                parent.$('#pCenter').css('display', 'block')
            } else {
                layer.msg("登录失败,请检查账号密码", {'icon': 2})
            }
        }, error: function () {
            layer.closeAll('loading');
            layer.msg("登录失败,请稍后再试", {'icon': 2})
        }
    });
}

function fillPass() {
    if (document.cookie != "" && document.cookie != null) {
        var arrCookie = document.cookie.split(';')
        var m = new Map
        for (var i = 0; i < arrCookie.length; i++) {
            var arr = arrCookie[i].trim().split('=')
            m.set(arr[0], arr[1])
        }
        if (m.get('account') != undefined && m.get('account') === $('#inputEmail3').val()) {
            $('#inputPassword3').val(m.get('pass'))
            $("#remember").prop("checked", true)
            $('#remember').val("1")
        }
    }
}


function forget() {
    layer.open({
        title: '忘记密码',
        type: 2,
        area: ['300px', '250px'], //宽高
        content: 'getForgetPage'
    });
}



$(function () {
    $('#loginBtn').click(login)

    $('#inputEmail3').change(fillPass)

    $('#remember').change(() => {
        if ($('#remember').val() == "0") {
            $('#remember').val("1")
        } else {
            $('#remember').val("0")
        }
    })

    $('#forget').click(forget)
})