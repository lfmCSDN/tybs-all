<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>桃源银行管理平台-登录</title>

    <link href="/src/images/logoo.ico" type="image/x-icon" rel="shortcut icon"/>
    <link rel="stylesheet" href="/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="/src/css/login.css"/>
</head>

<body>
<!--上面提示栏-->
<div class="layui-row">
    <div class="layui-col-md8">
        <!--滚动文字-->
        <div class="top-broadcast">
            <marquee><i
                    class="layui-icon layui-anim layui-anim-scaleSpring layui-anim-loop">&#xe645;</i>桃源银行公告：2018年是桃源银行成立1周年，该套系统是桃源人自己<span>独自设计</span>和<span>独自开发</span>真正惠于桃源人的银行！
            </marquee>
        </div>
    </div>
    <div class="layui-col-md4">
        <!--提示功能-->
        <div class="top-tips">
                    <span class="layui-breadcrumb" lay-separator="|">
                        <!--模板直接手动创建了，不通过代码生成-->
                        <a href="#">公告</a>
                    </span>
        </div>
    </div>
</div>

<div class="layui-container">
    <div class="layui-col-md4 layui-col-md-offset7">
        <!--登录框-->
        <div class="login-box">
            <!--登录框标题-->
            <div class="layui-row login-title">
                <div class="layui-col-md4 layui-col-md-offset2 login-logo">
                  <!--主题二-->
                    <img src="/src/images/login/login_title.png" alt=""/>
                </div>
            </div>
            <!--登录表单-->
            <div class="layui-row">
                <div class="layui-col-md12">
                    <div class="layui-tab layui-tab-brief">
                        <ul class="layui-tab-title">
                            <li class="layui-this"> 操作员</li>
                            <li>管理员</li>
                        </ul>
                        <div class="layui-tab-content">
                            <div class="layui-tab-item layui-show">
                                <!--账户登录  action="/operator/login" method="post"-->
                                <form class="layui-form" action="/operator/login" method="post">
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名&nbsp</label>
                                        <div class="layui-input-inline">
                                            <input class="layui-input" type="text" name="operName" required
                                                   lay-verify="required" lay-verType="tips" placeholder="请输入操作员姓名"/>
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码&nbsp</label>
                                        <div class="layui-input-inline">
                                            <input class="layui-input" type="password" name="loginPwd" required
                                                   lay-verify="required" lay-verType="tips" placeholder="请输入操作员密码"/>
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <div class="layui-input-block">
                                            <button class="layui-btn layui-btn-lg layui-btn-normal" lay-submit>&nbsp&nbsp&nbsp&nbsp&nbsp登&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp录&nbsp&nbsp&nbsp&nbsp&nbsp
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>

                            <div class="layui-tab-item">
                                <!--管理员登录-->
                                <form class="layui-form" action="/admin/login" method="post">
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名&nbsp</label>
                                        <div class="layui-input-inline">
                                            <input class="layui-input" type="text" name="adminName" required
                                                   lay-verify="required" lay-verType="tips" placeholder="请输入管理员姓名"/>
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码&nbsp</label>
                                        <div class="layui-input-inline">
                                            <input class="layui-input" type="password" name="adminPwd" required
                                                   lay-verify="required" lay-verType="tips" placeholder="请输入管理员密码"/>
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <div class="layui-input-block">
                                            <button class="layui-btn layui-btn-lg layui-btn-normal" lay-submit>&nbsp&nbsp&nbsp&nbsp&nbsp登&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp录&nbsp&nbsp&nbsp&nbsp&nbsp
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script type="text/javascript" src="/libs/layui/layui.js"></script>
<script type="text/javascript" src="/src/js/login.js"></script>
</body>
</html>