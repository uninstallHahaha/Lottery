
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

    function getRandomStr(){
        var len = 28;
        var $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678'; // 默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1
        var maxPos = $chars.length;
        var pwd = '';
        for (i = 0; i < len; i++) {
            pwd += $chars.charAt(Math.floor(Math.random() * maxPos));
        }
        return pwd;
    }


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
                    url: '/addAndReturnComment',
                    async: false,
                    data: {
                        'newsid': nid,
                        'userid': 'aclic',
                        'content': editor2.txt.text()
                    },
                    success: function (res) {
                        if (res.res == 1) {
                            layer.close(layerIndex)
                            layer.msg('发表成功!', {icon: 1});
                            //refresh DOM
                            var id='jianru'+getRandomStr()
                            var newCommentLiDOM = "<li id='"+id+"' style='opacity: 0' class=\"list-group-item commentLI\">" +
                                "<img alt=\"头像\" src='" + res.obj.av +"' "+
                                "class=\"commentAv\"></img>" +
                                "<div class=\"comConer\">" +
                                "<span class='comUser'>"+ res.obj.account+"</span>" +
                                "<span class=\"comCon\" title='"+res.obj.content+"'>"+res.obj.content+"</span>" +
                                "<span class=\"comTime\">"+(new Date(res.obj.createtime)).toLocaleString().replace('上午','').replace('下午','')+"</span>" +
                                "</div>" +
                                "</li>";
                            var num = parseInt($('#commentSize').text())+1
                            $('#commentSize').text(num)
                            $('li.commentLI').animate({
                                top: '40px',
                            }, 250);
                            $('#commentsUL:first-child').prepend(newCommentLiDOM);
                            $('#'+id).animate({
                                opacity: '1',
                            }, 400);
                            $('li.commentLI').animate({
                                top: '0px',
                            }, 250);
                            //remove no comment
                            $("#noConter").remove()
                        }else{
                            layer.msg(res.obj)
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

