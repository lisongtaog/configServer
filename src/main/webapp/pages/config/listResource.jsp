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

        <label for="appPkg">资源包信息</label>
        <!--前端解析后的资源信息-->
        <input id="appPkg" name="appPkg" />

        <input type="submit" value="查询" id="submit"/>
    </form>
</div>
<div>
    <table id="tab_resource">
        <thead>
            <tr>
                <th>ID</th>
                <th>国家</th>
                <th>类型</th>
                <th>应用包</th>
                <th>包名称</th>
                <th>有效状态</th>
                <th>缓存状态</th>
                <th>创建时间</th>
                <th>更新时间</th>
            </tr>
        </thead>
        <tbody>
        <tr>
            <td>ID</td>
            <td>国家</td>
            <td>类型</td>
            <td>应用包</td>
            <td>包名称</td>
            <td>有效状态</td>
            <td>缓存状态</td>
            <td>创建时间</td>
            <td>更新时间</td>
        </tr>
        </tbody>
        
    </table>
</div>
</body>
<script>
    $("#submit").click(function () {
        var data = $("#fm_resource").serializeObject();
        var url = "${ctx}/appPromotionConfig/listResource";
        $.ajax({
            url: url,
            type:"post",
            data:JSON.stringify(data),
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success: function (result) {
                if(ResponseCode.success === result.resultCode){
                    console.info(result.resultObj);
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
