//模拟点击input
function uploadPhoto() {
    $("#photoFile").click();
}

//展示上传文件的名字
function showPicName() {
    // $("#preview_photo").attr("src", $("#photoFile").val());
    var nameArr = $("#photoFile").val().split('\\')
    $("#picName").text(nameArr[nameArr.length-1])
}

//开始上传
function upload() {
    if ($("#photoFile").val() == '') {
        parent.layer.msg('请选择一张图片', {icon: 3})
        return;
    }
    var formData = new FormData();
    formData.append('avatar', document.getElementById('photoFile').files[0]);
    $.ajax({
        url: "uploadAvatar",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
            if (data.type == "success") {
                $("#preview_photo").attr("src", data.filepath + data.filename);
                $("#productImg").val(data.filename);
                // parent.layer.msg(data.msg, {icon: 1})
                //实时改变个人中心头像
                parent.$('#bigAV').attr("src", data.filepath + data.filename);
                parent.$('#avImg').attr("src", data.filepath + data.filename);
                //修改数据库
                $.ajax({
                    url:'modAv',
                    data:{av:data.filename},
                    success:function (res) {
                        if(res.stat==1){
                            parent.layer.msg("上传头像成功", {icon: 1})
                        }else{
                            parent.layer.msg(res.data, {icon: 2})
                        }
                    }
                })
            } else {
                parent.layer.msg(data.msg, {icon: 2})
            }
        },
        error: function (data) {
            parent.layer.msg('上传失败,请稍后再试', {icon: 2})
        }
    });
}

