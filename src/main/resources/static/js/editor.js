var E = window.wangEditor;
var editor = new E('#editor');
//var editor = new E( document.getElementById('editor') );
//editor.customConfig.uploadImgShowBase64 = true;  // 使用 base64 保存图片
editor.customConfig.uploadImgServer = '/admin/upload';
var save = function () {
    if ($('#title').val() == '') {
        alert("标题栏不能为空");
        return;
    } else if (editor.txt.html() == '') {
        alert("内容不能为空");
        return;
    }
    var blog = {};
    blog['title'] = $('#title').val();
    blog['text'] = editor.txt.html();
    var tag = $('#tag').val().split(',');
    blog['tags'] = tag;
    $.ajax({
        type: "POST",
        url: "/admin/save",
        dataType: "json",
        data: JSON.stringify(blog),
        processData: false,
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            console.log(data);
            if (data) {
                alert("保存成功");
                editor.txt.clear();
                $('#title').val("");
                $('#tag').val("");

            } else {
                alert("保存失败");
            }
        },
        error: function (e) {
            console.log("Error: " + e.status);
        }
    });
}
editor.create();