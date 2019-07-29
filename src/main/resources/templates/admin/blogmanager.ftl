<div class="container">
    <div class="row">
        <div class="col-md-12" style="margin-top: 20px;">
            <table class="table table-responsive" id="blogmanager">
                <caption>博客管理</caption>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="modal fade" id="updateDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 80%" role="form">
        <div class="modal-content form-group">
            <div class="modal-header" style="height: 70px;">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <input type="text" id="update-title" class="modal-title form-control" style="height: 100%;width: 400px"/>
            </div>
            <div class="modal-body">
                <div id="update-editor">

                </div>
                <br/>
                <div class="form-group">
                    <label>标签</label>
                    <input id="update-tag" type="text" class="form-control" style="width: 400px;display: inline-block"/>
                    <div style="display: inline">&nbsp;(多个关键字之间用“,”分隔)</div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="sureUpdate">提交更改</button>
            </div>
        </div>
    </div>
</div>
