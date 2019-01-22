<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>存款</title>
    <link href="/src/images/logoo.ico" type="image/x-icon" rel="shortcut icon"/>
    <link rel="stylesheet" href="/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="/src/css/bankSaving.css"/>
</head>

<body>
<form class="layui-form" action="/acct/bankSaving">

    <div class="layui-form-item">
        <label class="layui-form-label">银行卡号：</label>
        <div class="layui-input-inline">
            <input type="text" name="cardId" required lay-verify="required|number" placeholder="请输入银行卡号"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>

##    <div class="layui-form-item">
##        <label class="layui-form-label">账户姓名：</label>
##        <div class="layui-input-inline">
##            <input type="text" name="acctName" required lay-verify="required" placeholder="请输入账户姓名"
##                   autocomplete="off" class="layui-input">
##        </div>
##    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">存入金额：</label>
        <div class="layui-input-inline">
            <input type="text" name="amount" required lay-verify="required|number" placeholder="请输入存入金额"
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
<script type="text/javascript" src="/src/js/bankSaving.js"></script>
</body>
</html>