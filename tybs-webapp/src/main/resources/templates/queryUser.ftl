<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>首页</title>
    <link href="/src/images/logoo.ico" type="image/x-icon" rel="shortcut icon"/>
    <link rel="stylesheet" href="/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="/src/css/queryUser.css"/>
</head>

<body>
<form class="layui-form" action="">
    <div class="layui-row">
        <div class="layui-col-md4 layui-col-md-offset4 query-btn">
            <label class="layui-form-label">身份证号：</label>
            <div class="layui-input-inline">
                <input type="text" name="userCardId" required lay-verify="required" placeholder="请输入身份证号"
                       autocomplete="off" class="layui-input">
            </div>

            <div class="layui-form-item">
                <div class="layui-input-button">
                    <button class="layui-btn " lay-submit lay-filter="formDemo">查&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp询
                    </button>
                    <button type="reset" class="layui-btn layui-btn-primary">重&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp置
                    </button>
                </div>
            </div>
        </div>
    </div>
    </div>
    <hr>
</form>
<table id="User"></table>
##<script type="text/html" id="user">
##    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">注销账户</a>
##</script>
<script type="text/javascript" src="/libs/layui/layui.js"></script>
<script type="text/javascript" src="/src/js/queryUser.js"></script>
</body>
</html>