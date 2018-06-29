<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/rootBase.jsp"%>
<html>
<head>
    <title>查询推广规则</title>
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

        <button id="queryRule">查询</button>
    </form>
</div>
<div>
    <table id="tab_rule">
        <thead>
        <tr>
            <td>id</td>
            <td>country</td>
            <td>app_pkg</td>
            <td>conditions</td>
            <td>priority</td>
            <td>validstatus</td>
            <td>init</td>
            <td>popupTimes</td>
            <td>comments</td>
            <td>action_type</td>
            <td>link_url</td>
            <td>package_name</td>
            <td>title</td>
            <td>message</td>
            <td>icon_url</td>
            <td>big_image_url</td>
            <td>image_native_url</td>
            <td>create_time</td>
            <td>update_time</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>id</td>
            <td>country</td>
            <td>app_pkg</td>
            <td>conditions</td>
            <td>priority</td>
            <td>validstatus</td>
            <td>init</td>
            <td>popupTimes</td>
            <td>comments</td>
            <td>action_type</td>
            <td>link_url</td>
            <td>package_name</td>
            <td>title</td>
            <td>message</td>
            <td>icon_url</td>
            <td>big_image_url</td>
            <td>image_native_url</td>
            <td>create_time</td>
            <td>update_time</td>
        </tr>
        </tbody>
    </table>
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
        $("#fm_rule").validate({
            rules: rules,
            messages:messages
        });
    });

    //指定数据属性,最终展示该属性的value值
    var columns = [
        { "data": "id"},
        { "data": "country" },
        { "data": "app_pkg"},
        { "data": "conditions"},
        { "data": "priority"},
        { "data": "validstatus"},
        { "data": "init"},
        { "data": "popupTimes"},
        { "data": "comments"},
        { "data": "action_type"},
        { "data": "link_url"},
        { "data": "package_name"},
        { "data": "title"},
        { "data": "message"},
        { "data": "icon_url"},
        { "data": "big_image_url"},
        { "data": "image_native_url"},
        { "data": "create_time"},
        { "data": "update_time"}
    ];

    var options = {
        "searching": false,// 是否允许检索
        "ordering":false,
        "info": true,// 是否显示情报 就是"当前显示1/100记录"这个信息
        "serverSide": true,//服务器端分页
        "paging": true,// 是否允许翻页，设成false，翻页按钮不显示
        "scrollX": false,// 水平滚动条
        "scrollY": false,// 垂直滚动条
        "lengthMenu": [1,10, 25, 50],// 件数选择下拉框内容
        "pageLength": 10,// 每页的初期件数 用户可以操作lengthMenu上的值覆盖
        //翻页按钮样式
        // numbers:数字;// simple:前一页，后一页;// simple_numbers:前一页，后一页，数字;// full:第一页，前一页，后一页，最后页
        //full_numbers:第一页，前一页，后一页，最后页，数字;//first_last_numbers:第一页，最后页，数字
        "pagingType": "full_numbers",
        // 行样式应用 指定多个的话，第一行tr的class为strip1，第二行为strip2，第三行为strip3.
        // 第四行以后又开始从strip1循环。。。 如果想指定成斑马条状，这里的class必须指定为2个。
//        "stripeClasses": ['strip1', 'strip2'],
        //"autoWidth": true,// 自动列宽
        "processing": true,// 是否表示 "processing" 加载中的信息，这个信息可以修改
        "destroy": true,// 每次创建是否销毁以前的DataTable,默认false
        "select": true,
        "dom": "Blfrtip",
        "fnCreatedRow":function(nRow, aData, iDataIndex){
            //console.info(aData);//
        },
        "columnDefs":[
            {//倒数第一列
                "targets":-1,
                "bSortable": false,
                render: function(data, type, row) {
                    var html ='<button value="'+row.id+'">编辑</button>&nbsp;&nbsp;'
                        +'<button onclick="del('+ row.id + ')">删除</button>';
                    return html;
                }
            },
        ]
    };
    options.columns = columns;
    options.ajax = function(data, callback, settings){
        //console.info(callback);
        //console.info(settings);
        fetchData(data, callback);
    };

    function fetchData(dataTableData,callback){
        var data = $("#fm_rule").serializeObject();
        data.pageNo = dataTableData.start / dataTableData.length;
        data.pageSize = dataTableData.length;

        var url = "${ctx}/appPromotionConfig/listRule";
        $.ajax({
            url: url,
            type:"post",
            data:JSON.stringify(data),
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success: function (result) {
                if(ResponseCode.success === result.resultCode){
                    var responeData = result.resultObj;
                    //console.info(responeData);
                    console.info(responeData.list);
                    callback(
                        {
                            "recordsTotal": responeData.totalCount,
                            "recordsFiltered": responeData.totalCount,
                            "data": responeData.list
                        }
                    );
                }
            },
            error:AJAXerror
        });
    }

    //触发查询
    $("#queryRule").click(function () {
        $('#tab_resource').DataTable(options);
    });

    $().ready(function() {
        $('#tab_rule').DataTable(options);
    });

    /**
     * 删除
     * @param id
     */
    function del(id){
        alert(id);
        var url = "${ctx}/appPromotionConfig/deleteRule";
        $.ajax({
            url: url,
            type:"post",
            data:"id="+ id,
            dataType:"json",
            success: function (result) {
                if(ResponseCode.success === result.resultCode){
                    alert("删除成功!");
                    //TODO 刷新数据表格
                    //$("#tab_resource").DataTable().fnDraw(false);
                }
            },
            error:AJAXerror
        });
    };

</script>
</html>
