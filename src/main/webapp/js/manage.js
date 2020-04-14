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
            message: 'Hello Vue!',
            curPage : 1,//1.main page 2.write article
            userData: {
                account: 'alice',
                av: '/uploads/avatars/cat.jpg'
            },
        },
        methods:{
            switchPage: (num)=>{
                this.$data.curPage = num;
            }
        }
    })

})