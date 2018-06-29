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
        <input type="text" id="id" name="id"  value="1572"/>
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

        <label for="appPkg">应用包</label>
        <input type="text" id="appPkg" name="appPkg"/>

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
