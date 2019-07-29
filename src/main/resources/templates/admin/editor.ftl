<div class="container" style="margin-top: 15px;">
    <div class="row">
        <div class="col-md-12">
            <form role="form">
                <div class="form-group">
                    <label>标题</label>
                    <input id="title" type="text" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>内容</label>
                    <div id="editor">

                    </div>
                </div>
                <br/>
                <div class="form-group">
                    <form role="form">
                        <label>标签</label>
                        <input id="tag" type="text" class="form-control" style="width: 400px;display: inline-block"/>
                        <div style="display: inline">&nbsp;(多个关键字之间用“,”分隔)</div>
                    </form>
                </div>
                <div class="col-md-12">
                    <a href="javascript:void(0);" onclick="save()"  class="btn btn-link pull-right"
                       style="background-color: #0a0091;
                                color: white;
                                margin-top: 20px;
                                margin-right: 20px;
                                padding-top: 5px;
                                padding-left:15px;
                                padding-right: 15px;">提交</a>
                </div>
            </form>
        </div>
    </div>
</div>
