$(function () {

    var E = window.wangEditor
    var editor2 = new E('#editor')
    editor2.customConfig.menus = [
        'head',  // 标题
        'bold',  // 粗体
        'fontSize',  // 字号
        'fontName',  // 字体
        'italic',  // 斜体
        'underline',  // 下划线
        'strikeThrough',  // 删除线
        'foreColor',  // 文字颜色
        'backColor',  // 背景颜色
        'link',  // 插入链接
        'list',  // 列表
        'justify',  // 对齐方式
        'quote',  // 引用
        'emoticon',  // 表情
        'undo',  // 撤销
        'redo'  // 重复
    ]
    editor2.create()

    $('#addComBtn').bind('click', addCom)
    $('#addComBtn').bind('mouseover', showTip)


    function addCom() {
        //clear
        editor2.txt.clear()
        let layerIndex;
        layer.open({
            type: 1,
            title: '发表评论',
            skin: 'layui-layer-rim', //加上边框
            area: ['800px', '440px'], //宽高
            content: $('#editor'),
            btn: ['发表', '取消'],
            yes: function (index, layero) {
                //save index for close
                layerIndex = index
                //add comment
                var nid = $('#nid').text()
                $.ajax({
                    type: 'POST',
                    url: '/addComment',
                    async: false,
                    data: {
                        'newsid': nid,
                        'userid': 'aclic',
                        'content': editor2.txt.text()
                    },
                    success: function (res) {
                        if (res == 1) {
                            layer.close(layerIndex)
                            layer.msg('发表成功!', {icon: 1});
                            //refresh DOM
                            //TODO...
                        }
                    },
                    error: function () {
                        layer.msg('发表失败,请重试', {icon: 2});
                    }
                });

            }
        });
    }

    function showTip() {
        layer.tips('发表评论', '#addComBtn');
    }

})

