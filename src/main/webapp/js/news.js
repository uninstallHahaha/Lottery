$(function () {

    function getNewsCount() {
        //ajax
    }

    function getNewNews() {
        $.ajax({
            type: 'POST',
            url: '/lazyGetNews',
            data: {'start': newsIndex},
            success: (res) => {
                newsIndex += 10
                refreshNewsDOM(res)
            }
        });
        return [];
    }

    function refreshNewsDOM(newNews) {
        //refreshNews DOM
        if (newNews.length == 0) {
            //no new
            var nonewDOM = "<div class='nonew'>没有更多新闻...</div>"
            $('#newslistUl').append(nonewDOM)
            $('#newslistDiv').unbind('scroll')
        } else {
            //op DOM
            var newnewsDOM = ""
            newNews.forEach((news, index) => {
                newnewsDOM += " <li class='list-group-item'>" +
                    "<a class='newsTitle' href='newsDetail.html'>" + news.title + "</a>" +
                    "<span class='newsTime'>" + timestampFormat(news.createtime) + "</span>" +
                    "<span class='newsDesc'>" + news.content.substring(0, 205).concat('...') + "</span>" +
                    "<div id='zandiv' class='zandiv'>"

                if (news.ifSupport) {
                    newnewsDOM += "<span id='zan' class='zan zaned' newsid='"+news.id+"'>"
                    newnewsDOM += '已赞同'
                } else {
                    newnewsDOM += "<span id='zan' class='zan' newsid='"+news.id+"'>"
                    newnewsDOM += "赞同"
                }
                newnewsDOM +=
                    news.zan +
                    "</span>" +
                    "</div>" +
                    "</li>"
            })
            $('#newslistUl:last-child').append(newnewsDOM)
            //给新来的绑定点击
            $('.zan').click(zan)
            $('.zaned').unbind('click')
            $('.zaned').click(nozan)
        }
    }

    let newsCount = 0;
    let newsIndex = 10;

    let nScrollHight = 0; //滚动距离总长(注意不是滚动条的长度)
    let nScrollTop = 0;   //滚动到的当前位置
    let nDivHight = $("#newslistDiv").height();
    $('#newslistDiv').bind('scroll', function () {//为页面添加页面滚动监听
        nScrollHight = $(this)[0].scrollHeight;
        nScrollTop = $(this)[0].scrollTop;
        let paddingBottom = parseInt($(this).css('padding-bottom'))
        let paddingTop = parseInt($(this).css('padding-top'));
        if (nScrollTop + paddingBottom + paddingTop + nDivHight >= nScrollHight)
            // alert("滚动条到底部了");
            //懒加载
            getNewNews()

    })


    function zan(t) {
        var ni = t.target.getAttribute('newsid')
        $.ajax({
            url: 'zanAdd',
            method: 'POST',
            data: {
                'newsid': ni,
            },
            success: function (r) {
                if (r.res == 1) {
                    layer.msg('已赞同')
                    //更新dom
                    var newsid = this.data.split('=')[1]
                    var spanDOM = $("[newsid="+newsid+"]")
                    spanDOM.addClass('zaned')
                    spanDOM.text('已赞同'+r.data)
                    //更新click
                    spanDOM.unbind('click')
                    spanDOM.click(nozan)
                } else {
                    layer.msg(r.data)
                }
            }
        })
    }
    function nozan(t){
        var ni = t.target.getAttribute('newsid')
        $.ajax({
            url: 'zanMinus',
            method: 'POST',
            data: {
                'newsid': ni,
            },
            success: function (r) {
                if (r.res == 1) {
                    layer.msg('已取消')
                    //更新dom
                    var newsid = this.data.split('=')[1]
                    var spanDOM = $("[newsid="+newsid+"]")
                    spanDOM.removeClass('zaned')
                    spanDOM.text('赞同'+r.data)
                    //更新click
                    spanDOM.unbind('click')
                    spanDOM.click(zan)
                } else {
                    layer.msg(r.data)
                }
            }
        })
    }

    $('.zan').click(zan)
    $('.zaned').unbind('click')
    $('.zaned').click(nozan)

})