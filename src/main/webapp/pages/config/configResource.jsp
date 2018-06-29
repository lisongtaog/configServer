<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/rootBase.jsp"%>
<html>
<head>
    <title>应用资源配置</title>
</head>
<body>
<div>
    <form id="fm_resource">
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
        <label for="appType">应用类型</label>
        <select name="appType" id="appType">
            <option value="01">游戏</option>
            <option value="02">CallFlash</option>
            <option value="03">杀毒</option>
            <option value="04">计步器</option>
            <option value="05">翻译</option>
            <option value="06">voip</option>
            <option value="07">VPN</option>
            <option value="08">喝水宝</option>
        </select>

        <label for="appResource">资源包信息</label>
        <!--前端解析后的资源信息-->
        <textarea id="appResource" name="appResource" rows="5" cols="30"></textarea>

        <input type="submit" value="提交" id="submit"/>
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


    $("#submit").click(function () {
        var data = $("#fm_resource").serializeObject();
        data.appResource = parseResource(data.appResource);
        var poupMsg = confirm("共计配置资源：" + data.appResource.length +"个，确认提交吗？");
        if(poupMsg){
            var url = "${ctx}/appPromotionConfig/addAppResource";
            $.ajax({
                url: url,
                type:"post",
                data:JSON.stringify(data),
                contentType:"application/json;charset=utf-8",
                dataType:"json",
                success: function (result) {
                    if(ResponseCode.success === result.resultCode){
                        alert("新增成功");
                        document.getElementById("#fm_resource").reset();
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
        }
        return false;
    });

    /**
     * 解析用户上传的数字符串
     * @param jsonStr
     * @returns {*}
     */
    function parseResource(jsonStr) {
        var resource = [];
        try{
            resource = $.parseJSON(jsonStr);
        }catch (e){
            console.info("parse resource app to json array failed ! by defaule:regard the single value as a APP resource");
            resource.push(jsonStr);
        }
        return resource;
    }

</script>
</html>
