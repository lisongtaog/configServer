<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/rootBase.jsp"%>
<html>
<head>
    <title>应用规则配置</title>
</head>
<body>
<div>
    <table id="tab_rule">
        <thead>
        <tr>
            <th>ID</th>
            <th>国家</th>
            <th>应用包</th>
            <th>匹配规则条件</th>
            <th>优先级</th>
            <th>有效状态</th>
            <th>缓存状态</th>
            <th>广告弹出次数</th>
            <th>响应类型</th>
            <th>推广链接</th>
            <th>包名称</th>
            <th>Tittle</th>
            <th>Message</th>
            <th>icon_url</th>
            <th>big_image_url</th>
            <th>native_image_url</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>13</td>
            <td>GB</td>
            <td>DEFAULT</td>
            <td>appType='01' && installed=1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>3</td>
            <td>app</td>
            <td>www.baidu.com</td>
            <td>com.personalization.call.flash</td>
            <td>Daily Solitaire</td>
            <td>Cool incoming call animation, make your caller is unique</td>
            <td>http://images.uugame.info/fullads/ic_callflash_new.png</td>
            <td>http://images.uugame.info/fullads/callflash_new.jpg</td>
            <td>http://images.uugame.info/nativeads/callflash_new.jpg</td>
            <td>2018-06-22 11:59:31</td>
            <td>2018-06-22 11:59:31</td>
            <td>备注</td>
            <td><button class="update">修改</button><button class="delete">删除</button></td>
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

    $(".delete").click(function () {
        var id = 1572;
        var url = "${ctx}/appPromotionConfig/deleteAppResource?id=" + id;
        $.ajax({
            url: url,
            type:"get",
            data:JSON.stringify(id),
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success: function (result) {
                if(ResponseCode.success === result.resultCode){
                    alert("删除成功");
                    document.getElementById("#fm_resource").reset();
                }else {
                    alert("删除失败");
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
