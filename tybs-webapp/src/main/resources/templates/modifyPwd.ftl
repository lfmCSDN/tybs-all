<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>修改密码</title>
    <link href="/src/images/logoo.ico" type="image/x-icon" rel="shortcut icon"/>
    <link rel="stylesheet" href="/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="/src/css/modifyPwd.css"/>
</head>

<body>
<form class="layui-form" action="">

    <div class="layui-form-item">
        <label class="layui-form-label">银行卡号：</label>
        <div class="layui-input-inline">
            <input type="text" name="cardId" required lay-verify="required|number" placeholder="请输入银行卡号"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">原密码：</label>
        <div class="layui-input-inline">
            <input type="password" name="transPwd" style="display:none">
            <input type="password" name="transPwd" required lay-verify="required|number" placeholder="请输入原交易密码"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">新密码：</label>
        <div class="layui-input-inline">
            <input type="password" name="transPwd1" style="display:none">
            <input type="password" name="transPwd1" required lay-verify="required|number" placeholder="请输入新交易密码"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码：</label>
        <div class="layui-input-inline">
            <input type="password" name="transPwd2" style="display:none">
            <input type="password" name="transPwd2" required lay-verify="required|number" placeholder="请再次输入新交易密码"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-button">
            <button class="layui-btn" lay-submit lay-filter="formDemo">确&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp定</button>
            <button type="reset" class="layui-btn layui-btn-primary">取&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp消</button>
        </div>
    </div>

</form>
<script type="text/javascript" src="/libs/layui/layui.js"></script>
<script type="text/javascript" src="/src/js/modifyPwd.js"></script>
</body>
</html>