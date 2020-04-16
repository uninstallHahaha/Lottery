$(function () {

    Vue.filter('dataFormat', function (value, fmt) {
        let getDate = new Date(value);
        let o = {
            'M+': getDate.getMonth() + 1,
            'd+': getDate.getDate(),
            'h+': getDate.getHours(),
            'm+': getDate.getMinutes(),
            's+': getDate.getSeconds(),
            'q+': Math.floor((getDate.getMonth() + 3) / 3),
            'S': getDate.getMilliseconds()
        };
        if (/(y+)/.test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (getDate.getFullYear() + '').substr(4 - RegExp.$1.length))
        }
        for (let k in o) {
            if (new RegExp('(' + k + ')').test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (('00' + o[k]).substr(('' + o[k]).length)))
            }
        }
        return fmt;
    });

    function initUserInfo() {
        $.ajax({
            url: 'getLoginUserInfo',
            method: 'POST',
            success: (res) => {
                app.$data.userData = res
            }
        })
    }

    function initNews() {
        $.ajax({
            url: 'getNews',
            method: 'POST',
            success: (res) => {
                app.$data.newsList = res
            }
        })
    }

    function initUsers() {
        $.ajax({
            url: 'getUsers',
            method: 'POST',
            success: (res) => {
                res = res.filter(function (item) {
                    return item.id != app.$data.userData.id
                });
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
            ifmain: true,
            userData: {
                account: 'alice',
                av: '/uploads/avatars/cat.jpg'
            },
            //article
            article: {
                title: '',
                body: '',
            },
            newsList: []
            ,
            usersList: [],
        },
        beforeMount: function () {
            initNews()
            initUsers()
        },
        computed: {
            formatTime: function (datetime) {
                var date = new Date(datetime);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
                var year = date.getFullYear(),
                    month = ("0" + (date.getMonth() + 1)).slice(-2),
                    sdate = ("0" + date.getDate()).slice(-2),
                    hour = ("0" + date.getHours()).slice(-2),
                    minute = ("0" + date.getMinutes()).slice(-2),
                    second = ("0" + date.getSeconds()).slice(-2);
                // 拼接
                var result = year + "-" + month + "-" + sdate + " " + hour + ":" + minute + ":" + second;
                // 返回
                return result;
            }
        },
        methods: {
            //切换到发布
            switchPage: function () {
                this.ifmain = false
            }
            ,
            //返回到管理台
            returnMain: function () {
                this.ifmain = true
            }
            ,
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
            }
            ,
            //草稿
            saveArticle: function () {
                let stitle = this.article.title
                let sbody = $('#articleBody').text()
                if(stitle=="" || sbody==""){
                    layer.msg('标题和文章不能为空')
                    return
                }
                $.ajax({
                    url: 'addNewsAsScr',
                    method: 'POST',
                    data: {title: stitle, body: sbody},
                    success: function (res) {
                        if (res.stat == 1) {
                            layer.msg('保存成功', {icon: 1})
                        } else {
                            layer.msg(res.data, {icon: 2})
                        }
                    }
                })
            }
            ,
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
            }
            ,
            //删除新闻
            delNews: function (id, title) {
                layer.confirm('确定删除新闻 "' + title + '" ?', {
                    btn: ['确认', '取消']
                }, function () {
                    $.ajax({
                        url: 'delNews',
                        data: {id: id},
                        success: function (res) {
                            if (res == 1) {
                                layer.msg('删除成功', {icon: 1})
                                initNews()
                            }
                        }
                    })
                })
            }
            ,
            //注销用户
            outUser: function (id, account) {
                layer.confirm('确定注销用户 "' + account + '" ?', {
                    btn: ['确认', '取消']
                }, function () {
                    $.ajax({
                        url: 'delUser',
                        data: {id: id},
                        success: function (res) {
                            if (res == 1) {
                                layer.msg('注销成功', {icon: 1})
                                initUsers()
                            }
                        }
                    })
                })
            }
            ,
            //邮箱tip
            tipEmail: function () {
                layer.tips('绑定邮箱后可使用邮箱找回密码', '#bindEmail')
            }
            ,
            //绑定邮箱
            bindEmail: function () {
                layer.open({
                    title: '绑定邮箱',
                    type: 2,
                    // btn: ['确定', '取消'],
                    area: ['420px', '240px'], //宽高
                    content: 'getEmailPage',
                });
            }
        }
    })



})