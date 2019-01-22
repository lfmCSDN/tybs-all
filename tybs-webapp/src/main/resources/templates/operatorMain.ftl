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
                    <span>尊敬的操作员：$!{loginName} 您好!您此次登录时间为：$!{loginTime}</span>
                </a>
            </li>
            <li class="layui-nav-item">
                <a href="/operator/exit">
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
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon " style="font-size: 20px;">&#xe620;</i> &nbsp;账户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" name="/operator/addUserVm">
                            <i class="layui-icon " style="font-size: 20px;">&#xe613;</i>&nbsp;开通账户</a></dd>
                        <dd><a href="javascript:;" name="/operator/queryUserVm">
                            <i class="layui-icon" style="font-size: 20px; ">&#xe615;</i>&nbsp;&nbsp;&nbsp;查询账户</a></dd>
                        <dd><a href="javascript:;" name="/operator/operCardVm">
                            <i class="layui-icon" style="font-size: 20px; ">&#xe614;</i>&nbsp;&nbsp;&nbsp;账户操作</a></dd>
                        <dd><a href="javascript:;" name="/operator/toModifyPwd">
                            <i class="layui-icon" style="font-size: 20px; ">&#xe639;</i>&nbsp;&nbsp;&nbsp;客户修改密码</a></dd>
                        <dd><a href="javascript:;" name="/operator/toResetPwd">
                            <i class="layui-icon" style="font-size: 20px; ">&#xe639;</i>&nbsp;&nbsp;&nbsp;重置密码</a></dd>
                        <dd><a href="javascript:;" name="/operator/toModifyUser">
                            <i class="layui-icon" style="font-size: 20px; ">&#xe63b;</i>&nbsp; &nbsp;账户修改</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon " style="font-size: 20px;">&#xe65e;</i> &nbsp;交易管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" name="/acct/toBankSaving">
                            <i class="layui-icon" style="font-size: 20px; ">&#xe61f;</i>&nbsp; &nbsp;账户存款</a></dd>
                        <dd><a href="javascript:;" name="/acct/toDrawMoney">
                            <i class="layui-icon" style="font-size: 20px; ">&#xe672;</i>&nbsp; &nbsp;账户取款</a></dd>
                        <dd><a href="javascript:;" name="/acct/toTransfer">
                            <i class="layui-icon" style="font-size: 20px; ">&#xe656;</i>&nbsp; &nbsp;账户转账</a></dd>
                        <dd><a href="javascript:;" name="/acct/toTransferByMoney">
                            <i class="layui-icon" style="font-size: 20px; ">&#xe656;</i>&nbsp; &nbsp;现金转账</a></dd>
                        <dd><a href="javascript:;" name="/acct/toTransList">
                            <i class="layui-icon" style="font-size: 20px; ">&#xe63c;</i>&nbsp; &nbsp;交易明细</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;" name="">
                    <i class="layui-icon " style="font-size: 20px;">&#xe653;</i> &nbsp;其他功能</a></li>
                <li class="layui-nav-item"><a href="javascript:;" name="">
                    <i class="layui-icon " style="font-size: 20px;">&#xe681;</i> &nbsp;云服务</a></li>
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
            </div>
            <div class="layui-footer">
            </div>
        </div>
    </div>
</div>
<script src="/libs/layui/layui.js"></script>
<script type="text/javascript" src="/src/js/main.js"></script>
</body>
</html>