$(function () {

    function initUserInfo() {
        $.ajax({
            url: 'getLoginUserInfo',
            method: 'POST',
            success: (res) => {
                app.$data.userData = res
            }
        })
    }

    initUserInfo()

    var app = new Vue({
        el: '#app',
        data: {
            counter: 0,
            message: 'Hello Vue!',
            ifmain: false,
            userData: {
                account: 'alice',
                av: '/uploads/avatars/cat.jpg'
            },
            //article
            article: {
                title: '',
                body: '',
            }
        },
        methods: {
            //切换到发布
            switchPage:function(){
                this.ifmain=false
            },
            //返回到管理台
            returnMain:function(){
                this.ifmain=true
            },
            //发布新闻
            sendArticle: function () {
                $.ajax({
                    url: 'addNews',
                    method: 'POST',
                    data: {title: this.article.title,body:$('#articleBody').text() },
                    success: function (res) {
                        if (res.stat == 1) {
                            layer.msg('发布成功', {icon: 1})
                        } else {
                            layer.msg(res.data, {icon: 2})
                        }
                    }
                })
            },
            //草稿
            saveArticle:function () {
                $.ajax({
                    url: 'addNewsAsScr',
                    method: 'POST',
                    data: {title: this.article.title,body:$('#articleBody').text() },
                    success: function (res) {
                        if (res.stat == 1) {
                            layer.msg('保存成功', {icon: 1})
                        } else {
                            layer.msg(res.data, {icon: 2})
                        }
                    }
                })
            }
        }
    })

})