function delScr(id) {
    $.ajax({
        url: 'delNews',
        data: {
            id: id
        },
        success: function (res) {
            if (res == 1) {
                layer.msg('删除成功', {icon: 1})
                $("[newsid="+id+"]").remove()
                if($('#scrsUl').children().length==0){
                    let noSrcDom = " <div class=\"noConter\">\n" +
                        "                        <div class=\"noCommentDivzan\"></div>\n" +
                        "                        <div class=\"noCommentTip\">暂无草稿</div>\n" +
                        "                    </div>"
                    $('#scrsUl').append(noSrcDom)
                }
            } else {
                layer.msg('删除失败', {icon: 2})
            }
        },
        error:function () {
            layer.msg('删除失败',{icon:2})
        }
    })
}


$(function () {

    $('.loadSrcBtn').click(function (e) {
        let newsid = $(e.target).attr('newsid')
        $.ajax({
            url: 'getOneNews',
            data: {id: newsid},
            success: function (r) {
                parent.$('#articleTile').text(r.title)
                parent.$('#articleBody').text(r.content)
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index)
                parent.layer.msg('加载成功', {icon: 1})
            }
        })

    })

})