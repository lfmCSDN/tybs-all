<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>修改手机号码</title>
    <link href="/src/images/logoo.ico" type="image/x-icon" rel="shortcut icon"/>
    <link rel="stylesheet" href="/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="/src/css/modifyUser.css"/>
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
</form>
<hr>
<table id="table-modifyUser"></table>
<script type="text/html" id="modify-User">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="modifyUser">账户修改</a>
</script>
<script type="text/javascript" src="/libs/layui/layui.js"></script>
<script type="text/javascript" src="/src/js/modifyUser.js"></script>
</body>
</html>