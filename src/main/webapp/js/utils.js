//时间格式化
function timestampFormat(tstamp){
    return (new Date(tstamp)).toLocaleString()
}

//时间通俗化
function dateToNormal(d){
    let minute = 1000 * 60;
    let hour = minute * 60;
    let day = hour * 24;
    let month = day * 30;

    let now = new Date().getTime()
    let diffValue = now - d.getTime()

    let monthC =diffValue/month;
    let weekC =diffValue/(7*day);
    let dayC =diffValue/day;
    let hourC =diffValue/hour;
    let minC =diffValue/minute;
    let result;
    if(monthC >=1){
        return d;
    }
    else if(weekC>=1){
        result="发表于" + Math.round(weekC) + "个星期前";
    }
    else if(dayC>=1){
        result="发表于"+ parseInt(dayC) +"天前";
    }
    else if(hourC>=1){
        result="发表于"+ parseInt(hourC) +"个小时前";
    }
    else if(minC>=1){
        result="发表于"+ parseInt(minC) +"分钟前";
    }else
        result="刚刚发表";
    
    return result
}