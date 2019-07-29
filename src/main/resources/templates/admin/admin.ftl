<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>admin</title>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/font-awesome.css"rel="stylesheet">
    <script src="/static/js/jquery-1.12.4.min.js"></script>
    <script src="/static/js/wangEditor.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>

</head>
<style>
    .img-title{
        float: left;
        height: 50px;
        font-size: 18px;
        line-height: 20px;
        padding-right: 15px;
    }
    body{
        background-color: #f0f2f5;
    }
    .body{
        background-color: #f8f8f8;
        min-height: 600px;
        max-width: 1250px;
        margin-right: auto;
        margin-left: auto;
    }
</style>
<body>
    <div class="navbar-fixed-container">
        <nav class="navbar navbar-default  affix-top"  role="navigation">
            <div class="nav navbar-header">
                <img src="/static/biaozhi.jpg" class="img-title"/>
                <button type="button" class="navbar-toggle"
                        data-toggle="collapse" data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav navbar-left">
                    <li>
                        <a href="javascript:void(0);" onclick="bodydisplay('body1')">
                            <i class="fa fa-home"></i>
                            <strong class="h5">首页</strong>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" onclick="bodydisplay('body2')">
                            <i class="fa fa-pencil-square-o" ></i>
                            <strong class="h5">写博客</strong>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" onclick="bodydisplay('body3')">
                            <i class="fa fa-bars"></i>
                            <strong class="h5">博客管理</strong>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" onclick="bodydisplay('body4')">
                            <i class="fa fa-user-secret"></i>
                            <strong class="h5">个人信息</strong>
                        </a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li class="navbar-right dropdown">
                        <img src="/static/touxiang.jpg" class="img-circle img-title dropdown-toggle" data-toggle="dropdown">
                        <ul class="dropdown-menu" style="width: 30px">
                            <li>
                                <a href="#"><i class="fa fa-sign-out"></i>注销</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="body row" id="body1">
        <#include "home.ftl">
    </div>
    <div class="body row" id="body2" style="display: none;">
        <#include "editor.ftl">
    </div>
    <div class="body row" id="body3" style="display: none;">
        <#include "blogmanager.ftl">
    </div>
    <div class="body row" id="body4" style="display: none;">
        <#include "persnoalnfo.ftl">
    </div>
</body>
<script src="/static/js/editor.js"></script>
<script src="/static/js/personinfo.js"></script>
<script src="/static/js/blogmanager.js"></script>
<script>
    var bodydisplay = function(body){
        $("#body1").hide();
        $("#body2").hide();
        $("#body3").hide();
        $("#body4").hide();
        $("#" + body).show();
        if(body=="body3"){
            getAllBlog();
        }
    }
</script>
</html>