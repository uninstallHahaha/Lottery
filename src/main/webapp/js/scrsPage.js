$(function () {

    $('.scrLi').click(function (e) {
        let newsid = $(e.target).attr('newsid')
        $.ajax({
            url: 'getOneNews',
            data: {id: newsid},
            success: function (r) {
                parent.$('#articleTile').text(r.title)
                parent.$('#articleBody').text(r.content)
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index)
                parent.layer.msg('加载成功',{icon:1})
            }
        })

    })

})