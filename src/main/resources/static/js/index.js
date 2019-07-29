$(function(){
    ajaxPage(1);
    $("#myPage").sPage({
        page:1,//当前页码
        pageSize:8,//每页显示多少条数据，默认10条
        total:$('#total').html(),//数据总条数
        showSkip:true,//是否显示跳页，默认关闭：false
        showPN:false,//是否显示上下翻页，默认开启：true
        backFun:function(page){
            //点击分页按钮回调函数
            ajaxPage(page);
        }
    });
});
//使用ajax获取和该页数据
function ajaxPage(page){
    $.ajax({
        type: "GET",
        url: "/page",
        async : false,
        data: {
            currentPage:page,
            pageSize:8,
        },
        dataType: "json",
        success: function(data){
            $('#articles').empty();
            var total = data['total'];
            $('#total').html(total);
            $.each(data['list'],function(index,item){
                // console.log(GetChinese(item['text']));
                $('#articles').append("<article id='article-" +
                    index+ "'><a class='h3' style='font-weight: 550;display: block' href='/article?aid=" + item['id'] +"'>" + item['title'] + "</a>"  + GetChinese(item['text']) + "</article>");
                $('#article-' + index).append("<br/>");
                $.each(item['tagList'],function(index1,item1){
                    $('#article-' + index).append("<span style='margin-right: 10px;color: #7f7d7f'>" + item1['tag'] + "</span>");
                });
            });
        },
        error:function(e){
            alert("请求数据出错")
        }
    });
}
function GetChinese(strValue) {
    if(strValue!= null && strValue!= ""){
        var reg = /[\u4e00-\u9fa5]/g;
        var chinese = strValue.match(reg);
        if(chinese!=null){
            if(chinese.length>500){
                return chinese.substring(0,100).join("");
            }else{
                return chinese.join("");
            }
        }else{
            return " ";
        }
    }
    else
        return "";
}