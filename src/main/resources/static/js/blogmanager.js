var E1 = window.wangEditor;
var updateEditor = new E1('#update-editor');
updateEditor.customConfig.uploadImgServer = '/admin/upload';
updateEditor.create();
var getAllBlog = function () {
    $('#blogmanager tbody').empty();
    $.ajax({
        type: "POST",
        url: "/admin/getall",
        dataType: "json",
        processData: false,
        contentType: false,
        success: function (data) {
            $.each(data, function (index, item) {
                //console.log(index + "..." + item);
                var d = new Date(item["createTime"]);
                var dateTime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
                $('#blogmanager tbody').append(
                    "<tr>" +
                    "<td style='height: 60px'>" +
                    "<a id='blog-title-" + item["id"] + "'  data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse" + index + "\" class=\"h3\">" +
                    item["title"] + "</a>" + "<small class=\"pull-right\">" + dateTime + "</small>" +
                    "<div id=\"collapse" + index + "\" class=\"panel-collapse collapse\">" +
                    "<hr/>" +
                    "<div class=\"panel-body\" id='blog-" + item["id"] + "'>" +
                    item["text"] +
                    "</div>" +
                    "<strong class='h3'>标签:  </strong>" +
                    "<div id='tags-in" + item["id"] + "'></div>" +
                    "<hr/>" +
                    "<div>" +
                    "<a " + "id=\"" + "update" + item["id"] + "\"" + "class=\"btn\" onclick=\"insertUpdateEditor('"+ item["id"] + "')\">修改</a>" +
                    "<a " + "id=\"" + "delete" + item["id"] + "\"" + "class=\"btn\" onclick=\"deleteBlog('" + +item["id"] + "')\">删除</a>" +
                    "<a " + "id=\"" + "fold" + item["id"] + "\"" + "class=\"btn\" onclick=\"fold('collapse" + index + "')\" >折叠</a>" +
                    "</div>" +
                    "</div>" +
                    "</td>" +
                    "</tr>"
                )
                $.each(item['tagList'], function (index1, item1) {
                    $('#tags-in' + item["id"]).append('' + item1['tag']);
                    if (index1 != item['tagList'].length - 1) {
                        $('#tags-in' + item["id"]).append(",");
                    }
                });
            });
        },
        error: function (e) {
            alert("请求数据失败");
        }
    });
}
var fold = function (id1) {
    $('#' + id1).collapse('hide');
}
var insertUpdateEditor = function (blogId) {
    $('#update-title').val($('#blog-title-' + blogId).html());
    updateEditor.txt.html($('#blog-' + blogId).html());
    $('#update-tag').val($('#tags-in' + blogId).html());
    $('#updateDialog').modal('show');
    //先移除事件，再绑定事件
    $('#sureUpdate').unbind('click').click(function () {
        update(blogId);
    });
}
var update = function(id){
    var updateBlog={};
    updateBlog['id'] = id;
    updateBlog['title'] = $('#update-title').val();
    updateBlog['text'] = updateEditor.txt.html();
    updateBlog['tags'] =  $('#update-tag').val().split(',');
    $.ajax({
        type: "POST",
        url: "/admin/update",
        dataType: "json",
        data:JSON.stringify(updateBlog),
        processData: false,
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            if(data){
                getAllBlog();
                alert('更新成功');
            }else{
                alert('更新失败');
            }

        }
    });
}
var deleteBlog = function (blogId) {
    if (confirm("您正在删除一篇博客!")) {
        $.ajax({
            type: "POST",
            url: "/admin/delete",
            dataType: "json",
            data: {
                id: blogId
            },
            success: function (data) {
                if (data) {
                    getAllBlog();
                    alert("删除成功");
                } else {
                    alert("删除失败");
                }
            }
        });
    }
}