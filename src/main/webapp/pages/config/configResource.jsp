<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/rootBase.jsp"%>
<html>
<head>
    <title>新增资源配置</title>
</head>
<body>
<%--<div>--%>
    <%--<form id="fm_resource">--%>
        <%--<label for="country">国家</label>--%>
        <%--<input type="text" id="country" name="country"/>--%>
        <%--&lt;%&ndash;后续读取数据库配置，下拉框展示 &ndash;%&gt;--%>
        <%--&lt;%&ndash;<select name="country" id="country">--%>
            <%--<option value="DEFAULT">默认</option>--%>
            <%--<option value="US">美国</option>--%>
            <%--<option value="AU">澳大利亚</option>--%>
            <%--<option value="CA">加拿大</option>--%>
            <%--<option value="GB">德国</option>--%>
        <%--</select>&ndash;%&gt;--%>
        <%--<label for="appType">应用类型</label>--%>
        <%--<select name="appType" id="appType">--%>
            <%--<option value="01">游戏</option>--%>
            <%--<option value="02">CallFlash</option>--%>
            <%--<option value="03">杀毒</option>--%>
            <%--<option value="04">计步器</option>--%>
            <%--<option value="05">翻译</option>--%>
            <%--<option value="06">voip</option>--%>
            <%--<option value="07">VPN</option>--%>
            <%--<option value="08">喝水宝</option>--%>
        <%--</select>--%>

        <%--<label for="appResource">资源包信息</label>--%>
        <%--<!--前端解析后的资源信息-->--%>
        <%--<textarea id="appResource" name="appResource" rows="5" cols="30"></textarea>--%>

        <%--<input type="submit" value="提交" id="submit"/>--%>
    <%--</form>--%>

<%--</div>--%>
<div class="container">
    <fieldset>
        <legend>新增资源配置</legend>
    </fieldset>
</div>
<div class="container">
    <form id="fm_resource" class="form-horizontal">
        <div class="form-group">
            <label for="id" class="control-label col-md-2">主键</label>
            <div class="col-md-8">
            <input type="text" id="id" name="id" readonly="readonly" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="country" class="col-md-2 control-label">国家</label>
            <div class="col-md-3">
                <select name="country" id="country" class="form-control">
                </select>
            </div>

            <label for="appType" class="col-md-2 control-label">应用类型</label>
            <div class="col-md-3">
                <select name="appType" id="appType" class="form-control">
                    <option value="01">游戏</option>
                    <option value="02">CallFlash</option>
                    <option value="03">杀毒</option>
                    <option value="04">计步器</option>
                    <option value="05">翻译</option>
                    <option value="06">voip</option>
                    <option value="07">VPN</option>
                    <option value="08">喝水宝</option>
                    <option value="09">Solitaire</option>
                    <option value="10">CoinPusher</option>
                </select>
            </div>

        </div>

        <div class="form-group">
            <label for="appResource" class="control-label col-md-2">资源包</label>
            <div class="col-md-8">
                <textarea id="appResource" name="appResource" rows="5" class="form-control" placeholder='输入格式:JSONArray["com.app1","com.app2"] 或 单独的字符串'></textarea>
            </div>
        </div>

        <div class="form-group">
            <label for="validstatus" class="col-md-2 control-label">有效状态</label>
            <div class="col-md-3">
                <select id="validstatus" name="validstatus" class="form-control">
                    <option value="1">有效</option>
                    <option value="0">无效</option>
                </select>
            </div>
            <label for="init" class="control-label col-md-2">初始化状态</label>
            <div class="col-md-3">
                <%--如果修改，应该是 未初始化--%>
                <select id="init" name="init" class="form-control">
                    <option value="0" selected="selected">未初始化</option>
                    <%--<option value="1">已初始化</option>--%>
                </select>
            </div>
        </div>

        <div class="form-group">
            <button id="submit" class="btn btn-default col-lg-1 col-lg-offset-5">提交</button>
        </div>
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

    //表单验证器
    var validator;

    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        validator = $("#fm_resource").validate({
            rules: rules,
            messages:messages,
            onfocusin: function(element) { $(element).valid(); },
            onfocusout: function(element) { $(element).valid(); },
            onclick: function(element) { $(element).valid(); },
            onkeyup: function(element) { $(element).valid(); }
        });
        //加载国家下拉框
        var countryDropdown = $("#country");
        var url = "${ctx}/DropdownMenu/queryCountry";
        $.ajax({
            url:url,
            type:"post",
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function(result){
                console.log(result);
                for(var i = 0;i<result.length;i++){
                    var one = result[i];
                    var option = $("<option value='" + one.country_code + "'>" + one.country_name + "</option>");
                    countryDropdown.append(option);
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
    });


    $("#submit").click(function () {
        if(!validator.valid()){
            alert("表单验证未通过");
            return false;
        }
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
                        validator.resetForm();
                        //document.getElementById("fm_resource").reset();
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
            console.info("parse resource app to json array failed ! by default:regard the single value as a APP resource");
            resource.push(jsonStr);
        }
        return resource;
    }

</script>
</html>
