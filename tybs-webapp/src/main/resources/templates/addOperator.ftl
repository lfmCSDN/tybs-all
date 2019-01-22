<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>添加操作员</title>
    <link href="/src/images/logoo.ico" type="image/x-icon" rel="shortcut icon"/>
    <link rel="stylesheet" href="/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="/src/css/addOperator.css"/>
</head>


<body>
<form class="layui-form">

    <div class="layui-form-item">
        <label class="layui-form-label">操作员号：</label>
        <div class="layui-input-inline">
            <input type="text" name="userOperInfoId" required lay-verify="required|number" lay-verType="tips" placeholder="请输入操作员号"
                   autocomplete="off"
                   class="layui-input">
        </div>

        <label class="layui-form-label">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：</label>
        <div class="layui-input-inline">
            <input type="text" name="operName" required lay-verify="operName" lay-verType="tips" placeholder="请输入操作员姓名"
                   autocomplete="off"
                   class="layui-input">
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">登录密码：</label>
            <div class="layui-input-inline">
                <input type="password" name="loginPwd" style="display:none">
                <input type="password" name="loginPwd" required lay-verify="password" placeholder="请初始化登录密码"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">身份证号：</label>
        <div class="layui-input-inline">
            <input type="text" name="operCardId" required lay-verify="required|identity" placeholder="请输入身份证号"
                   autocomplete="off"
                   class="layui-input">
        </div>

        <label class="layui-form-label">手&nbsp&nbsp机&nbsp&nbsp号：</label>
        <div class="layui-input-inline">
            <input type="text" name="operMobilPhone" required lay-verify="required|phone|number" placeholder="请输入手机号"
                   autocomplete="off"
                   class="layui-input">
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别：</label>
            <div class="layui-input-block">
                <input type="radio" name="operSex" value="男" title="男">
                <input type="radio" name="operSex" value="女" title="女" checked>
            </div>
        </div>
    </div>

    <div class="layui-form-item">


        <label class="layui-form-label">邮&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp箱：</label>
        <div class="layui-input-inline">
            <input type="text" name="operEmail" required lay-verify="required|email" placeholder="请输入联系邮箱"
                   autocomplete="off"
                   class="layui-input">
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">操作状态：</label>
            <div class="layui-input-block">
                <input type="radio" name="operStatu" value="正常" title="正常" checked>
                <input type="radio" name="operStatu" value="不正常" title="不正常">
            </div>
        </div>
    </div>

    <div class="layui-input-button">
        <button class="layui-btn" lay-submit lay-filter="formDemo">
            增&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp加
        </button>
        <button type="reset" class="layui-btn layui-btn-primary">
            重&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp置
        </button>
    </div>

</form>
<script type="text/javascript" src="/libs/layui/layui.js"></script>
<script type="text/javascript" src="/src/js/addOperator.js"></script>
</body>
</html>