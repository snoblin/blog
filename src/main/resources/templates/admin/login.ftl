<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>admin_login</title>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/font-awesome.css" rel="stylesheet">
    <script src="/static/js/jquery-1.12.4.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<style>
    .div1{
        width:20%;
        margin-top: 30px;
        margin-left: auto;
        margin-right: auto;
    }
</style>
<body>
    <div class="container div1">
        <div class="row">
            <div >
                <img src="/static/snolin.png" class="img-responsive">
            </div>
            <div class="center-block">
                <form class="form-horizontal" role="form">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input id="username" type="text" class="form-control"/>
                    </div>
                    <br/>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                        <input id="passwd" type="password" class="form-control"/>
                    </div>
                    <br/>
                    <div>
                        <button type="submit" class="btn btn-info btn-block">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>