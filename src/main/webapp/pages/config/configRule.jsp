<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/rootBase.jsp"%>
<html>
<head>
    <title>推广规则配置</title>
</head>
<body>
<div>
    <form id="fm_rule">
        <label for="appPkg">应用包</label><%--可配置DEFAULT--%>
        <input type="text" id="appPkg" name="appPkg"/>
        <label for="country">国家</label><%--可配置DEFAULT--%>
        <input type="text" id="country" name="country"/>
        <%--后续读取数据库配置，下拉框展示 --%>
        <%--<select name="country" id="country">
            <option value="DEFAULT">默认</option>
            <option value="US">美国</option>
            <option value="AU">澳大利亚</option>
            <option value="CA">加拿大</option>
            <option value="GB">德国</option>
        </select>--%>

        <label for="conditions">条件</label>
        <textarea id="conditions" name="conditions" rows="5" cols="30"></textarea>

        <label for="priority">优先级</label>
        <select name="priority" id="priority">
            <c:forEach var="index" begin="1" end="10" step="1">
                <option value="${index}">${index}</option>
            </c:forEach>
        </select>
        <br/>

        <label for="actionType">推广类型</label>
        <select name="actionType" id="actionType">
            <option value="app">app</option>
            <option value="link">link</option>
        </select>

        <label for="popuptimes">推广次数</label>
        <input type="text" id="popuptimes" name="popuptimes" value="3"/>

        <label for="linkUrl">推广链接</label>
        <input type="text" id="linkUrl" name="linkUrl"/>

        <label for="packageName">推广应用包</label>
        <input type="text" id="packageName" name="packageName"/>

        <label for="title">title</label>
        <input type="text" id="title" name="title"/>
        <br/>

        <label for="message">message</label>
        <input type="text" id="message" name="message"/>

        <label for="iconUrl">iconUrl</label>
        <input type="text" id="iconUrl" name="iconUrl"/>

        <label for="bigImageUrl">bigImageUrl</label>
        <input type="text" id="bigImageUrl" name="bigImageUrl"/>

        <label for="nativeImageUrl">nativeImageUrl</label>
        <input type="text" id="nativeImageUrl" name="nativeImageUrl"/>
        <br/>

        <label for="comments">备注说明</label>
        <textarea id="comments" name="comments" rows="5" cols="30"></textarea>

        <input type="submit" value="提交" id="submit"/>
    </form>

</div>
</body>
<script>
    var rules = {
        country:"required",
        appPkg:"required",
        conditions:"required"
    };
    var messages = {
        country: "必录项",
        appPkg: "必录项",
        conditions: "必录项"
    };

    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        $("#fm_resource").validate({
            rules: rules,
            messages:messages
        });
    });


    $("#submit").click(function () {
        var data = $("#fm_rule").serializeObject();
        var url = "${ctx}/appPromotionConfig/addAppRule";
        $.ajax({
            url: url,
            type:"post",
            data:JSON.stringify(data),
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success: function (result) {
                if(ResponseCode.success === result.resultCode){
                    alert("新增成功");
                    document.getElementById("#fm_rule").reset();
                }else {
                    alert("新增失败");
                }
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                // 状态码
                console.log(XMLHttpRequest.status);
                // 状态
                console.log(XMLHttpRequest.readyState);
                // 错误信息
                console.log(textStatus);
            }
        });
        return false;
    });

</script>
</html>
