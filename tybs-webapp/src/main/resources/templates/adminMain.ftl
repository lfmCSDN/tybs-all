<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>综合管理平台-首页</title>
    <link href="/src/images/logoo.ico" type="image/x-icon" rel="shortcut icon"/>
    <link rel="stylesheet" href="/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="/src/css/main.css"/>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><span>桃源银行综合管理平台</span></div>
        <dl class="layui-nav-child">
            <dd><a href="">邮件管理</a></dd>
            <dd><a href="">消息管理</a></dd>
            <dd><a href="">授权管理</a></dd>
        </dl>
        </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <span>尊敬的管理员：$!{loginName}您好!&nbsp;您此次登录时间为：$!{loginTime}</span>
                </a>
            ##                <dl class="layui-nav-child">
            ##                    <dd><a href="">基本资料</a></dd>
            ##                    <dd><a href="">安全设置</a></dd>
            ##                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="/admin/exit">
                    <i class="layui-icon" style="font-size: 20px; ">&#xe68e;
                    </i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="filter">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">
                        <i class="layui-icon " style="font-size: 20px;">&#xe620;</i> &nbsp;操作员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" name="/admin/addOperatorVm"> &nbsp; &nbsp; &nbsp; &nbsp;添加操作员</a></dd>
                        <dd><a href="javascript:;" name="/admin/queryOperatorVm"> &nbsp; &nbsp; &nbsp; &nbsp;查询操作员</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-body-style">
            <div class="layui-tab" lay-allowClose="true" lay-filter="new_tab">
                <ul class="layui-tab-title">
                    <li class="layui-this">首页</li>
                ##左边点击事件
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <div class="welcome_bg">
                            W e l c o m e
                        </div>
                    </div>
                </div>
            ##            <div class="layui-footer">
            ##            ##<!-- 底部固定区域 -->
            ##                ## <span>© www.taoyuan.com - 所有版权归桃源银行所有</span>
            ##            </div>
            </div>
        </div>
    </div>
    <script src="/libs/layui/layui.js"></script>
    <script type="text/javascript" src="/src/js/main.js"></script>
</body>
</html>