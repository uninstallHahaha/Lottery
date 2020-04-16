function subModPass(){
    let oldPs= $('#oldPass').val()
    let ps = $('#newPass').val()
    let reps = $('#reNewPass').val()
    if(ps.length<8){
        layer.msg('密码不能小于8位')
        return
    }
    $.ajax({
        type: 'POST',
        url: 'modPass',
        data: {
            oldPass : oldPs,
            newPass : ps,
            reNewPass : reps
        },
        success: (res) => {
            if(res.res == 1){
                parent.layer.msg("修改密码成功",{icon:1})
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }else{
                parent.layer.msg(res.data,{icon:2})
            }
        }
    });
}


$(function(){
    $("#subModPass").click(subModPass)
})