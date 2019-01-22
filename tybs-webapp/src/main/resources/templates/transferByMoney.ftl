<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>转账</title>
    <link href="/src/images/logoo.ico" type="image/x-icon" rel="shortcut icon"/>
    <link rel="stylesheet" href="/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="/src/css/transferByMoney.css"/>
</head>

<body>
<form class="layui-form" action="">

    <div class="layui-form-item">
        <label class="layui-form-label">收款户名：</label>
        <div class="layui-input-inline">
            <input type="text" name="receiptName" style="display:none">
            <input type="text" name="receiptName" required lay-verify="required" placeholder="请输入收款户名"
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">收款账号：</label>
        <div class="layui-input-inline">
            <input type="text" name="receiptCardId" style="display:none">
            <input type="text" name="receiptCardId" required lay-verify="required|number" placeholder="请输入收款账号"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">转账金额：</label>
        <div class="layui-input-inline">
            <input type="text" name="amount" style="display:none">
            <input type="text" name="amount" required lay-verify="required|number" placeholder="请输入转账金额"
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
<script type="text/javascript" src="/src/js/transferByMoney.js"></script>
</body>
</html>