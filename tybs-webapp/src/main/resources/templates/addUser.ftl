<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>增加用户</title>
    <link href="/src/images/logoo.ico" type="image/x-icon" rel="shortcut icon"/>
    <link rel="stylesheet" href="/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="/src/css/addUser.css"/>
</head>


<body>
<form class="layui-form">

    <div class="layui-form-item">
        <label class="layui-form-label">持卡姓名：</label>
        <div class="layui-input-inline">
            <input type="text" name="userName" style="display:none">
            <input type="text" name="userName" required lay-verify="userName" lay-verType="tips"
                   placeholder="请输入持卡人姓名"
                   autocomplete="off"
                   class="layui-input">
        </div>
        <label class="layui-form-label">银行卡号：</label>
        <div class="layui-input-inline">
            <input type="text" name="cardId" style="display:none">
            <input type="text" name="cardId" required lay-verify="cardId" lay-verType="tips" placeholder="请输入银行卡号"
                   autocomplete="off"
                   class="layui-input">
        </div>

##        <div class="layui-inline">
##            <label class="layui-form-label">卡&nbsp&nbsp状&nbsp&nbsp态：</label>
##            <div class="layui-input-block">
##                <select name="stat" lay-verify="required">
##                    <option value=""></option>
##                    <option value="正常">正常</option>
##                    <option value="挂失">挂失</option>
##                    <option value="冻结">冻结</option>
##                </select>
##            </div>
##        </div>
        <div class="layui-inline">
            <label class="layui-form-label">卡&nbsp&nbsp类&nbsp&nbsp型：</label>
            <div class="layui-input-block">
                <select name="cardType" lay-verify="required">
                    <option value=""></option>
                    <option value="借记卡">借记卡</option>
                    <option value="贷记卡">贷记卡</option>
                    <option value="储值卡">储值卡</option>
                </select>
            </div>
        </div>


    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">交易密码：</label>
        <div class="layui-input-inline">
            <input type="password" name="transPwd" style="display:none">
            <input type="password" name="transPwd" required lay-verify="transPwd" lay-verType="tips"
                   placeholder="请初始化交易密码"
                   autocomplete="off"
                   class="layui-input">
        </div>

        <label class="layui-form-label">身份证号：</label>
        <div class="layui-input-inline">
            <input type="text" name="userCardId" style="display:none">
            <input type="text" name="userCardId" required lay-verify="required|identity" lay-verType="tips"
                   placeholder="请输入身份证号"
                   autocomplete="off"
                   class="layui-input">
        </div>

        <label class="layui-form-label">预留手机：</label>
        <div class="layui-input-inline">
            <input type="text" name="userTel" required lay-verify="required|phone|number"
                   placeholder="请输入预留电话"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">

        <label class="layui-form-label">邮&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp箱：</label>
        <div class="layui-input-inline">
            <input type="text" name="userEmail" style="display:none">
            <input type="text" name="userEmail" required lay-verify="required|email" placeholder="请输入联系邮箱"
                   autocomplete="off"
                   class="layui-input">
        </div>

        <label class="layui-form-label">开户金额：</label>
        <div class="layui-input-inline">
            <input type="text" name="oveage" required lay-verify="required|number"
                   placeholder="请输入开户金额"
                   autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别：</label>
            <div class="layui-input-block">
                <input type="radio" name="userSex" value="男" title="男" checked>
                <input type="radio" name="userSex" value="女" title="女">
            </div>
        </div>
    </div>

    <div class="layui-form-item">

        <label class="layui-form-label">家庭住址：</label>
        <div class="layui-input-inline">
            <input type="text" name="userAddress" required lay-verify="userAddress" placeholder="请输入联系地址"
                   autocomplete="off"
                   class="layui-input">
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
<script type="text/javascript" src="/src/js/addUser.js"></script>
</body>
</html>