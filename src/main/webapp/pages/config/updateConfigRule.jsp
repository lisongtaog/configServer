<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/rootBase.jsp"%>
<html>
<head>
    <title>应用资源配置</title>
</head>
<body>
<div>
    <form id="fm_resource">
        <label for="id">ID</label>
        <input type="text" id="id" name="id"  value="14"/>
        <label for="country">国家</label>
        <input type="text" id="country" name="country"/>
        <%--后续读取数据库配置，下拉框展示 --%>
        <%--<select name="country" id="country">
            <option value="DEFAULT">默认</option>
            <option value="US">美国</option>
            <option value="AU">澳大利亚</option>
            <option value="CA">加拿大</option>
            <option value="GB">德国</option>
        </select>--%>

        <label for="appPkg">应用包</label>
        <input type="text" id="appPkg" name="appPkg"/>

        <label for="conditions">匹配规则条件</label>
        <input type="text" id="conditions" name="conditions"/>

        <label for="priority">优先级</label>
        <input type="text" id="priority" name="priority"/>

        <label for="validstatus">有效状态</label>
        <input type="text" id="validstatus" name="validstatus"/>

        <label for="init">缓存状态</label>
        <input type="text" id="init" name="init"/>

        <label for="popuptimes">广告弹出次数</label>
        <input type="text" id="popuptimes" name="popuptimes"/>

        <label for="actionType">响应类型</label>
        <input type="text" id="actionType" name="actionType"/>

        <label for="linkUrl">推广链接</label>
        <input type="text" id="linkUrl" name="linkUrl"/>

        <label for="packageName">包名称</label>
        <input type="text" id="packageName" name="packageName"/>

        <label for="title">Tittle</label>
        <input type="text" id="title" name="title"/>

        <label for="message">Message</label>
        <input type="text" id="message" name="message"/>

        <label for="iconUrl">icon_url</label>
        <input type="text" id="iconUrl" name="iconUrl"/>

        <label for="bigImageUrl">big_image_url</label>
        <input type="text" id="bigImageUrl" name="bigImageUrl"/>

        <label for="nativeImageUrl">native_image_url</label>
        <input type="text" id="nativeImageUrl" name="nativeImageUrl"/>

        <label for="createTime">创建时间</label>
        <input type="text" id="createTime" name="createTime"/>

        <label for="updateTime">更新时间</label>
        <input type="text" id="updateTime" name="updateTime"/>

        <label for="comments">备注</label>
        <input type="text" id="comments" name="comments"/>

        <input type="submit" value="更新" class="update"/>
    </form>

</div>
</body>
<script>
    var rules = {
        country:"required",
        appType:"required",
        appResource:"required"
    };
    var messages = {
        country: "必录项",
        appType: "必录项",
        appResource: "必录项"
    };

    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        $("#fm_resource").validate({
            rules: rules,
            messages:messages
        });
    });


    $(".update").click(function () {
        var data = $("#fm_resource").serializeObject();
        var url = "${ctx}/appPromotionConfig/updateAppResource";
        $.ajax({
            url: url,
            type:"post",
            data:JSON.stringify(data),
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success: function (result) {
                if(ResponseCode.success === result.resultCode){
                    alert("修改成功");
                    document.getElementById("#fm_resource").reset();
                }else {
                    alert("修改失败");
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

    /**
     * 解析用户上传的数字符串
     * @param jsonStr
     * @returns {*}
     */
    function parseResource(jsonStr) {
        var resource = $.parseJSON(jsonStr);
        return resource;
    }

</script>
</html>
