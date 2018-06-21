<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./common/rootBase.jsp"%>
<html>
<head>
    <title>jquery插件测试</title>
</head>
<body>
    <label>juqery-ui验证：</label>
    <label for="inputDate">日期插件</label>
    <input type="text" id="inputDate" />

    <div>
        <label>表单validate验证</label>
        <form id="fm">
            名字：<input type="text" name="firstName" id="firstName"/></br>
            用户名：<input type="text" name="userName" id="userName"/></br>
            邮箱：<input type="text" name="email" id="email"/></br>
            密码：<input type="text" name="password" id="password"/></br>
            确认密码：<input type="text" name="confirm_password" id="confirm_password"/></br>
            <input type="submit" value="提交" id="submit"/></br>
        </form>
    </div>

</body>

<script type="text/javascript">
    $("#inputDate" ).datepicker({
        defaultDate: "+1m +8d",
        minDate:"-1y",
        maxDate:"1y",
        dateFormat: "yy-mm-dd",
        altFormat: "yy-mm-dd",
        autoSize: true,
        changeYear: true,
        changeMonth: true,
        inline: true
    });

    var rules = {
        firstName:"required",
        userName:{
                    required: true,
                    minlength: 2
        },
        email: {
            required: true,
            email: true
        },
        password: {
            required: true,
            minlength: 5
        },
        confirm_password: {
            required: true,
            minlength: 5,
            equalTo: "#password"
        },
    };
    var messages = {
        firstName: "请输入您的名字",
        userName: {
                required: "请输入用户名",
                minlength: "用户名必需由两个字母组成"
        },
        password: {
            required: "请输入密码",
                minlength: "密码长度不能小于 5 个字母"
        },
        confirm_password: {
                required: "请输入密码",
                minlength: "密码长度不能小于 5 个字母",
                equalTo: "<font color='red'>两次密码输入不一致</font>"
        },
        email: "请输入一个正确的邮箱"
    };

    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        $("#fm").validate({
            rules: rules,
            messages:messages
        });
    });


 /*   $(document).ready(function() {
        // bind 'myForm' and provide a simple callback function
        $('#myForm').ajaxForm(function() {
            alert("Thank you for your comment!");
        });
    });
*/

</script>
</html>
