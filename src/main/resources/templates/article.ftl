<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="/static/js/jquery-1.12.4.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link href="/static/css/font-awesome.css"rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="assets/waifu.min.css?v=1.4.2" />
    <link rel="stylesheet" type="text/css" href="/static/css/jquery.sPage.css"/>
</head>
<style>
    body{
        background-color: #F4F8FB;
        display: flex;
        flex-direction: column;
        /*color: #555;*/
    }
    .head{
        text-align:center;
        background: url('/static/header.jpg') no-repeat center center/cover;
        overflow: hidden;
        position: relative;
        height: 75vh;
        z-index: -1;
    }
    .foot .foot-co {
        position: relative;
        text-align: center;
    }
</style>
<body>
    <header class="head">
        <div style="align-items: center">
            <img src="/static/touxiang.jpg" class="img-responsive img-circle center-block" style="width:150px;margin-top: 160px">
            <h2 style="color:white;font-size: 50px;font-weight: 100">snolin的个人博客</h2>
        </div>
    </header>
    <div style="margin: 0 auto;min-width: 892px;border-radius: 5px;">
        <div style="background-color: white;margin-top: 50px;" class="panel">
            <div class="panel-heading">
                ${title}
            </div>
            <div class="panel-body">
                ${text}
            </div>
            <div class="panel-footer">
                测试标签
            </div>
        </div>
    </div>
    <footer class="foot" style="background:#232323;height: 120px;">
        <div class="foot-co" style="margin-left: auto;margin-right: auto">
            <br/>
            <a  style="margin:10px;padding: 20px;color: white" href="https://github.com/snoblin/ProjectManage">
                <i class="fa fa-github fa-2x"></i>
            </a>
            <br/>
            <br/>
            <span style="color: white"><i class="fa fa-calendar-o"></i>&nbsp;${year}&nbsp;snolin的博客</span>

        </div>
    </footer>
    <div class="waifu">
        <div class="waifu-tips"></div>
        <canvas id="live2d" class="live2d"></canvas>
        <div class="waifu-tool">
            <span class="fui-home"></span>
            <span class="fui-chat"></span>
            <span class="fui-eye"></span>
            <span class="fui-user"></span>
            <span class="fui-photo"></span>
            <span class="fui-info-circle"></span>
            <span class="fui-cross"></span>
        </div>
    </div>
    <!-- 实现拖动效果，需引入 JQuery UI -->
    <script src="assets/jquery-ui.min.js?v=1.12.1"></script>
    <script src="assets/waifu-tips.min.js?v=1.4.2"></script>
    <script src="assets/live2d.min.js?v=1.0.5"></script>
    <script type="text/javascript">
        /!* 可直接修改部分参数 *!/
        live2d_settings['modelId']              = 2;
        live2d_settings['waifuDraggable'] = 'unlimited'; // 拖拽样式
        live2d_settings['modelStorage']         = true;         // 记录 ID (刷新后恢复)，可选 true(真), false(假)
        live2d_settings['modelRandMode']        = 'rand';     // 模型切换，可选 'rand'(随机), 'switch'(顺序)
        live2d_settings['modelTexturesRandMode']= 'rand';
        /!* 在 initModel 前添加 *!/
        initModel("assets/waifu-tips.json?v=1.4.2")
    </script>
</body>
</html>