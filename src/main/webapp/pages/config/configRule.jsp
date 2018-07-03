<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/rootBase.jsp"%>
<html>
<head>
    <title>推广规则配置</title>
</head>
<body>
<%--<div>--%>
    <%--<form id="fm_rule">--%>
        <%--<label for="appPkg">应用包</label>&lt;%&ndash;可配置DEFAULT&ndash;%&gt;--%>
        <%--<input type="text" id="appPkg" name="appPkg"/>--%>
        <%--<label for="country">国家</label>&lt;%&ndash;可配置DEFAULT&ndash;%&gt;--%>
        <%--<input type="text" id="country" name="country"/>--%>
        <%--&lt;%&ndash;后续读取数据库配置，下拉框展示 &ndash;%&gt;--%>
        <%--&lt;%&ndash;<select name="country" id="country">--%>
            <%--<option value="DEFAULT">默认</option>--%>
            <%--<option value="US">美国</option>--%>
            <%--<option value="AU">澳大利亚</option>--%>
            <%--<option value="CA">加拿大</option>--%>
            <%--<option value="GB">德国</option>--%>
        <%--</select>&ndash;%&gt;--%>

        <%--<label for="conditions">条件</label>--%>
        <%--<textarea id="conditions" name="conditions" rows="5" cols="30"></textarea>--%>

        <%--<label for="priority">优先级</label>--%>
        <%--<select name="priority" id="priority">--%>
            <%--<c:forEach var="index" begin="1" end="10" step="1">--%>
                <%--<option value="${index}">${index}</option>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>
        <%--<br/>--%>

        <%--<label for="actionType">推广类型</label>--%>
        <%--<select name="actionType" id="actionType">--%>
            <%--<option value="app">app</option>--%>
            <%--<option value="link">link</option>--%>
        <%--</select>--%>

        <%--<label for="popuptimes">推广次数</label>--%>
        <%--<input type="text" id="popuptimes" name="popuptimes" value="3"/>--%>

        <%--<label for="linkUrl">推广链接</label>--%>
        <%--<input type="text" id="linkUrl" name="linkUrl"/>--%>

        <%--<label for="packageName">推广应用包</label>--%>
        <%--<input type="text" id="packageName" name="packageName"/>--%>

        <%--<label for="title">title</label>--%>
        <%--<input type="text" id="title" name="title"/>--%>
        <%--<br/>--%>

        <%--<label for="message">message</label>--%>
        <%--<input type="text" id="message" name="message"/>--%>

        <%--<label for="iconUrl">iconUrl</label>--%>
        <%--<input type="text" id="iconUrl" name="iconUrl"/>--%>

        <%--<label for="bigImageUrl">bigImageUrl</label>--%>
        <%--<input type="text" id="bigImageUrl" name="bigImageUrl"/>--%>

        <%--<label for="nativeImageUrl">nativeImageUrl</label>--%>
        <%--<input type="text" id="nativeImageUrl" name="nativeImageUrl"/>--%>
        <%--<br/>--%>

        <%--<label for="comments">备注说明</label>--%>
        <%--<textarea id="comments" name="comments" rows="5" cols="30"></textarea>--%>

        <%--<input type="submit" value="提交" id="submit"/>--%>
    <%--</form>--%>

<%--</div>--%>
<div class="container">
    <fieldset>
        <legend>新增规则配置</legend>
    </fieldset>
</div>
<div class="container">
    <form id="fm_rule" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="id" class="col-md-1 control-label">主键</label>
            <div class="col-sm-3">
                <input type="text" id="id" name="id" readonly class="form-control"/>
            </div>

            <label for="country" class="col-md-1 control-label">国家</label>
            <div class="col-sm-3">
                <input type="text" id="country" name="country" class="form-control"/>
                <%--后续读取数据库配置，下拉框展示 --%>
                <%--<select name="country" id="country" class="form-control">
                    <option value="DEFAULT">默认</option>
                    <option value="US">美国</option>
                    <option value="AU">澳大利亚</option>
                    <option value="CA">加拿大</option>
                    <option value="GB">德国</option>
                </select>--%>
            </div>
            <label for="appPkg" class="col-md-1 control-label">应用包</label>
            <div class="col-sm-3">
                <input id="appPkg" type="text" name="appPkg" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for="priority" class="col-md-1 control-label">优先级</label>
            <div class="col-sm-3">
                <select id="priority" name="priority" class="form-control">
                    <c:forEach var="index" begin="1" end="10" step="1">
                        <option value="${index}">${index}</option>
                    </c:forEach>
                </select>
            </div>

            <label for="validstatus" class="col-md-1 control-label">有效<br/>状态</label>
            <div class="col-sm-3">
                <select id="validstatus" name="validstatus" class="form-control">
                    <option value="1">有效</option>
                    <option value="0">无效</option>
                </select>
            </div>

            <label for="init" class="col-md-1 control-label">缓存<br/>状态</label>
            <div class="col-sm-3">
                <select id="init" name="init" class="form-control">
                    <option value="1">有效</option>
                    <option value="0">无效</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="conditions" class="col-md-1 control-label">条件</label>
            <div class="col-sm-11">
                <textarea id="conditions" name="conditions" rows="3" cols="20" class="form-control"></textarea>
            </div>
        </div>

        <div class="form-group">
            <label for="popuptimes" class="col-md-1 control-label">广告弹出次数</label>
            <div class="col-sm-3">
                <input id="popuptimes" type="text" name="popuptimes" class="form-control"/>
            </div>

            <label for="actionType" class="col-md-1 control-label">推广<br/>类型</label>
            <div class="col-sm-3">
                <select name="actionType" id="actionType" class="form-control">
                    <option value="app">app</option>
                    <option value="link">link</option>
                </select>
            </div>

            <label for="linkUrl" class="col-md-1 control-label">推广<br/>链接</label>
            <div class="col-sm-3">
                <input id="linkUrl" type="text" name="linkUrl" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for="packageName" class="col-md-1 control-label">包名称</label>
            <div class="col-sm-3">
                <input id="packageName" type="text" name="packageName" class="form-control"/>
            </div>

            <label for="title" class="col-md-1 control-label">Title</label>
            <div class="col-sm-3">
                <input id="title" type="text" name="title" class="form-control"/>
            </div>

            <label for="message" class="col-md-1 control-label">Message</label>
            <div class="col-sm-3">
                <input id="message" type="text" name="message" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for="iconUrl" class="col-md-1 control-label">icon</label>
            <div class="col-sm-3">
                <input id="iconUrl" type="text" name="iconUrl" class="form-control">
            </div>

            <label for="bigImageUrl" class="col-md-1 control-label">BigImage</label>
            <div class="col-sm-3">
                <input id="bigImageUrl" type="text" name="bigImageUrl" class="form-control"/>
            </div>

            <label for="nativeImageUrl" class="col-md-1 control-label">Native<br/>Image</label>
            <div class="col-sm-3">
                <input id="nativeImageUrl" type="text" name="nativeImageUrl" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="comments" class="col-md-1 control-label">备注</label>
            <div class="col-sm-11">
                <textarea id="comments" name="comments" rows="3" cols="20" class="form-control"></textarea>
            </div>
        </div>
        <div class="form-group">
            <button id="submit" class="btn btn-default col-lg-1 col-lg-offset-6">提交</button>
        </div>
    </form>
</div>

</body>
<script>
    var rules = {
        country:"required",
        appPkg:"required",
        conditions:"required",
        popuptimes:{
            required:true,
            digits:true,
            range:[1,10]
        },
        linkUrl:{
            url:true
        },
        iconUrl:{
            url:true
        },
        bigImageUrl:{
            url:true
        },
        nativeImageUrl:{
            url:true
        }
    };
    var messages = {
        country: "必录项",
        appPkg: "必录项",
        conditions: "必录项"
    };

    //表单验证器
    var validator;

    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        validator = $("#fm_rule").validate({
            rules: rules,
            messages:messages,
            onfocusin: function(element) { $(element).valid(); },
            onfocusout: function(element) { $(element).valid(); },
            onclick: function(element) { $(element).valid(); },
            onkeyup: function(element) { $(element).valid(); }
        });
    });


    $("#submit").click(function () {

        if(!validator.valid()){
            alert("表单验证未通过");
            return false;
        }

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
                    validator.resetForm();
                    //document.getElementById("fm_rule").reset();
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
