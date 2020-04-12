function subModPass(){
    $.ajax({
        type: 'POST',
        url: 'modPass',
        data: {
            oldPass : $('#oldPass').val(),
            newPass : $('#newPass').val(),
            reNewPass : $('#reNewPass').val()
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