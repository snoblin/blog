<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8">
    <title>欢迎</title>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="/static/js/jquery-1.12.4.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link href="/static/css/font-awesome.css"rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="assets/waifu.min.css?v=1.4.2" />
    <link rel="stylesheet" type="text/css" href="/static/css/jquery.sPage.css"/>
</head>
<style>
    body {
        background-color: #F4F8FB;
        z-index: -1;
        min-height: 100%;
        display: flex;
        flex-direction: column;
    }
    article {
        padding: 20px;
        border-bottom: 1px solid rgba(127,125,127,0.19);
        font-size: medium;
    }
    .foot .foot-co {
        position: relative;
        text-align: center;
    }
    @media screen and (min-width: 786px) {
         .foot .foot-co::after{
             background: url('/static/footer.png') no-repeat center center/cover;
             position: absolute;
             bottom: 47px;
             width: 1040px;
             display: block;
             left:-62px;
             margin-right: auto;
             margin-left: auto;
             pointer-events: none;
             content: "";
             height: 315px;
        }
        .foot{
            margin-top: 245px;
        }
    }
    .head{
        text-align:center;
        background: url('/static/background.jpg') no-repeat center center/cover;
        overflow: hidden;
        height: 100vh;
        z-index: 2;
        position: relative;
    }
</style>
<body>
    <div>
        <header class="head">
            <div style="align-items: center">
                <div style="display: none" id="total"></div>
                <h2 style="color:white;margin-top:300px;font-weight: 700;font-size: 50px;">snolin的个人博客</h2>
                <h3 style="color:rgba(227,227,227,0.19);font-weight: 300;font-size: 40px;">编程菜鸡</h3>
                <a  class="btn" style="color:white;margin-top: 250px" onclick="">
                    <i class="fa fa-angle-down fa-5x"></i>
                </a>
            </div>
            <canvas id="bubbles" style="position: absolute;left: 0px;bottom: 0px;"></canvas>
        </header>
        <div style="margin: 0 auto;max-width: 892px;border-radius: 5px;">
            <div style="background-color: white;margin-top: 50px;">
                <div id="articles">

                </div>
                <nav style="text-align: center;padding: 26px">
                    <div id="myPage" class="demo"></div>
                    <div id="pNum1" class="num"></div>
                    <div id="myPage1" class="demo"></div>
                </nav>
            </div>
        </div>
    </div>
    <footer class="foot" style="background:#232323;height: 120px;">
        <div class="foot-co" style="max-width: 892px;margin-left: auto;margin-right: auto">
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
<script src="/static/js/jquery.sPage.min.js"></script>
<script src="/static/js/index.js"></script>
<script>
    // Canvas初始化
    var c = document.getElementById("bubbles"),
        bg = $('#background'),
        ctx = c.getContext('2d'),
        width = window.innerWidth;
        height = window.innerHeight;
        bubbleCount = 300,
        minRadius = 1,
        maxRadius = 6,
        speed = 0.06;
        x = width / bubbleCount;
    // 气泡数组
    var Bubbles = [];
    // 添加进数组
    for (var i = 0; i < bubbleCount; i++) {
        Bubbles.push({
            x: i * x,
            y: height * Math.random(),
            r: minRadius + Math.random() * (maxRadius - minRadius),
            speed: speed+Math.random()
        });
    }
    //初始化
    function bubble() {
        c.width = width;
        c.height = height;
        for (i = 0; i < Bubbles.length; i++) {
            var b = Bubbles[i];
            ctx.beginPath();
            ctx.arc(b.x, b.y, b.r, 0, 2 * Math.PI);
            b.alpha = .5 * (b.y / height);
            ctx.fillStyle = "hsla(30, 8%, 69%," + b.alpha + ")";
            ctx.fill();
            b.y -= b.speed;
            if (b.y < 300) {
                b.y = height;
            }
        }
    }
    // 绘画
    function draw() {
        bubble();
        window.requestAnimationFrame(draw);
    }
    draw();
    $(window).resize(function() {
        var width = $(window).width();
        c.width = width;
        c.height = height;
        //draw();
    })
</script>
</html>