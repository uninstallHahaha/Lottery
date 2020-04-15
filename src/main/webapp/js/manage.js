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

    function initNews(){
        $.ajax({
            url: 'getNews',
            method: 'POST',
            success: (res) => {
                app.$data.newsList = res
            }
        })
    }

    function initUsers(){
        $.ajax({
            url: 'getUsers',
            method: 'POST',
            success: (res) => {
                app.$data.usersList = res
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
            },
            newsList:[]
            ,
            usersList:[],
        },
        beforeMount:function(){
            initNews()
            initUsers()
        },
        methods: {
            //切换到发布
            switchPage: function () {
                this.ifmain = false
            },
            //返回到管理台
            returnMain: function () {
                this.ifmain = true
            },
            //发布新闻
            sendArticle: function () {
                $.ajax({
                    url: 'addNews',
                    method: 'POST',
                    data: {title: this.article.title, body: $('#articleBody').text()},
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
            saveArticle: function () {
                $.ajax({
                    url: 'addNewsAsScr',
                    method: 'POST',
                    data: {title: this.article.title, body: $('#articleBody').text()},
                    success: function (res) {
                        if (res.stat == 1) {
                            layer.msg('保存成功', {icon: 1})
                        } else {
                            layer.msg(res.data, {icon: 2})
                        }
                    }
                })
            },
            //草稿箱
            showScrs: function () {
                layer.open({
                    type: 2,
                    title: '草稿箱',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['500px', '90%'],
                    content: 'getScrsPage'
                });
            },
            //删除新闻
            delNews:function (id) {
                $.ajax({
                    url:'delNews',
                    data: {id:id},
                    success:function (res) {
                        if(res==1){
                            layer.msg('删除成功',{icon:1})
                            initNews()
                        }
                    }
                })
            },
            //注销用户
            outUser:function (id) {
                $.ajax({
                    url:'delUser',
                    data: {id:id},
                    success:function (res) {
                        if(res==1){
                            layer.msg('注销成功',{icon:1})
                            initUsers()
                        }
                    }
                })
            }
        }
    })

})