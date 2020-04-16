//模拟点击input
function uploadPhoto() {
    $("#photoFile").click();
}

//展示上传文件的名字和图片
function showPicName() {
    var nameArr = $("#photoFile").val().split('\\')
    $("#picName").text(nameArr[nameArr.length - 1])
    upload()
}

let newAVPath = ""
let newAVName = ""

//上传并回显
function upload() {
    layer.load(1, {
        shade: 0.2
    })
    var formData = new FormData();
    formData.append('avatar', document.getElementById('photoFile').files[0]);
    $.ajax({
        url: "uploadAvatar",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
            layer.closeAll('loading');
            if (data.type == "success") {
                $("#preview_photo").attr("src", data.filepath + data.filename);
                $("#productImg").val(data.filename);
                // 保存新头像地址
                newAVPath = data.filepath + data.filename
                newAVName = data.filename
            } else {
                parent.layer.msg('加载图片失败,请重试', {icon: 2})
            }
        },
        error: function (data) {
            layer.closeAll('loading');
            parent.layer.msg('加载图片失败,请稍后再试', {icon: 2})
        }
    });
}

//保存头像修改
function doAVUpload() {
    if ($("#photoFile").val() == '') {
        parent.layer.msg('请选择一张图片', {icon: 3})
        return;
    }
    layer.load(1, {
        shade: 0.2
    })
    //修改数据库
    $.ajax({
        url: 'modAv',
        data: {av: newAVName},
        success: function (res) {
            layer.closeAll('loading');
            //实时改变个人中心头像
            parent.$('#bigAV').attr("src", newAVPath);
            parent.$('#avImg').attr("src", newAVPath);
            if (res.stat == 1) {
                parent.layer.msg("上传头像成功", {icon: 1})
            } else {
                parent.layer.msg(res.data, {icon: 2})
            }
        },
        error: function () {
            layer.closeAll('loading');
            parent.layer.msg("上传头像失败,请稍后再试", {icon: 2})
        }
    })
}

