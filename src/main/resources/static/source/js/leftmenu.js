$(function () {
    //加载日志博客类别
    $.get("/blogtype/typelist",function (data) {
       var blogTypeList = $("#blogTypeList");
    //   循环遍历json数组
        $(data).each(function () {
           var li = "<li><span><a href='/index.html?typeId="+this.id+"'>"+this.typeName+" ("+this.blogCount+")</a></span></li>";
        //   将每一个li标签追加到ul标签
            $(blogTypeList).append(li);
        });
    },"json");

    //按博客日期查询
    $.get("/blog/blogDateList",function (data) {
        var blogList = $("#dateList");
        //   循环遍历json数组
        $(data).each(function () {
            var li = "<li><span><a href='/index.html?releaseDateStr="+this.releaseDateStr+"'>"+this.releaseDateStr+"("+this.blogCount+")</a></span></li>";
            //   将每一个li标签追加到ul标签
            $(blogList).append(li);
        });
    },"json");
})