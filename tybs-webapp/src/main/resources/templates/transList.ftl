<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>交易明细</title>
    <link href="/src/images/logoo.ico" type="image/x-icon" rel="shortcut icon"/>
    <link rel="stylesheet" href="/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="/src/css/transList.css"/>
</head>

<body>
<form class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">银行卡号：</label>
        <div class="layui-input-inline">
            <input type="text" name="transId" style="display:none">
            <input type="text" name="transId" required lay-verify="cardId" lay-verType="tips"
                   placeholder="请输入银行卡号"
                   autocomplete="off"
                   class="layui-input">
        </div>
        <label class="layui-form-label">起始时间：</label>
        <div class="layui-input-inline">
            <input type="text" name="startTime" required lay-verify="date" lay-verType="tips" id="startTime"
                   placeholder="请输入开始时间"
                   autocomplete="off"
                   class="layui-input">
        </div>
        <label class="layui-form-label">结束时间：</label>
        <div class="layui-input-inline">
            <input type="text" name="endTime" required lay-verify="date" lay-verType="tips" id="endTime"
                   placeholder="请输入结束时间"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-row">
        <div class="layui-col-md4 layui-col-md-offset4 query-btn">
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
    <hr>
</form>
<table id="trans" border-width="0px 93px 0px"></table>
<script type="text/javascript" src="/libs/layui/layui.js"></script>
<script type="text/javascript" src="/src/js/transList.js"></script>
</body>
</html>