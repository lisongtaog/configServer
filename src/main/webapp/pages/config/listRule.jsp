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

        <input type="button" value="查询" id="queryRule"/>
    </form>
</div>

<div id="editDIV" class="float" style="display: none;z-index: 9999;">
    <button class="closeBtn" style="float: right;">关闭</button>
    <form id="fm_edit" style="margin:50px 100px;">
        <label for="id">主&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;键</label>
        <input type="text" id="id" name="id" readonly/><br/>

        <label for="country">国&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家</label>
        <input type="text" id="country" name="country"/><br/>
        <%--后续读取数据库配置，下拉框展示 --%>
        <%--<select name="country" id="country">
            <option value="DEFAULT">默认</option>
            <option value="US">美国</option>
            <option value="AU">澳大利亚</option>
            <option value="CA">加拿大</option>
            <option value="GB">德国</option>
        </select>--%>
        <label for="appPkg">应用包</label>
        <input id="appPkg" type="text" name="appPkg"/>
        <br/>

        <label for="conditions">条件&nbsp;&nbsp;</label>
        <input id="conditions" name="conditions">
        <br/>

        <label for="priority">优先级</label>
        <select id="priority" name="priority">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
        <br/>

        <label for="validstatus">有效状态</label>
        <select id="validstatus" name="validstatus">
            <option value="1">有效</option>
            <option value="0">无效</option>
        </select><br/>

        <label for="init">缓存状态</label>
        <input type="text" id="init"  name="init"/>
        <br/>

        <label for="popuptimes">广告弹出次数</label>
        <input id="popuptimes" type="text" name="popuptimes"/>
        <br/>

        <label for="actionType">响应类型</label>
        <input id="actionType" type="text" name="actionType"/>
        <br/>

        <label for="linkUrl">推广链接</label>
        <input id="linkUrl" type="text" name="linkUrl"/><br/>

        <label for="packageName">包名称</label>
        <input id="packageName" type="text" name="packageName"/><br/>

        <label for="title">Title</label>
        <input id="title" type="text" name="title"/><br/>

        <label for="message">Message</label>
        <input id="message" type="text" name="message"/><br/>

        <label for="iconUrl">icon</label>
        <input id="iconUrl" type="text" name="iconUrl"><br/>

        <label for="bigImageUrl">bigImage</label>
        <input id="bigImageUrl" type="text" name="bigImageUrl"><br/>

        <label for="nativeImageUrl">nativeImage</label>
        <input id="nativeImageUrl" type="text" name="nativeImageUrl"><br/>

        <label for="comments">备注</label>
        <input id="comments" type="text" name="comments"><br/>

        <input type="submit" value="提交" id="edit"/>
    </form>
</div>
<div>
    <table id="tab_rule" class="cell-border stripe myof">
        <thead>
        <tr>
            <th>ID</th>
            <th>国家</th>
            <th>应用包</th>
            <th>条件</th>
            <th>优先级</th>
            <th>有效状态</th>
            <th>缓存状态</th>
            <th>广告弹出次数</th>
            <th>响应类型</th>
            <th>推广链接</th>
            <th>包名称</th>
            <th>Tittle</th>
            <th>Message</th>
            <th>icon</th>
            <th>bigImage</th>
            <th>nativeImage</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
<script>

    //指定数据属性,最终展示该属性的value值
    var columns = [
        { "data": "id"},
        { "data": "country" },
        { "data": "appPkg"},
        { "data": "conditions"},
        { "data": "priority"},
        { "data": "validstatus"},
        { "data": "init"},
        { "data": "popuptimes"},
        { "data": "actionType"},
        { "data": "linkUrl"},
        { "data": "packageName"},
        { "data": "title"},
        { "data": "message"},
        { "data": "iconUrl"},
        { "data": "bigImageUrl"},
        { "data": "nativeImageUrl"},
        { "data": "createTime"},
        { "data": "updateTime"},
        { "data": "operate"}
    ];
    var rowIndex = 0;
    var options = {
        "searching": false,// 是否允许检索
        "ordering":false,
        "info": true,// 是否显示情报 就是"当前显示1/100记录"这个信息
        "serverSide": true,//服务器端分页
        "paging": true,// 是否允许翻页，设成false，翻页按钮不显示
        "scrollX": false,// 水平滚动条
        "scrollY": false,// 垂直滚动条
        "lengthMenu": [10, 25, 50],// 件数选择下拉框内容
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
                    var html ='<a href="javascript:void(0);" onclick="preEdit('+ ++rowIndex + ')">编辑</a>&nbsp;&nbsp;'
                        +'<a href="javascript:void(0);" onclick="del('+ row.id + ')">删除</a>';
                    return html;
                }
            },
            {
                "visible": false,
                "targets": [5,6,7,-2,-3]
            }
        ]
    };
    options.columns = columns;
    options.ajax = function(data, callback, settings){
        //console.info(callback);
        //console.info(settings);
        fetchData(data, callback);
    };


    function fetchData(dataTableData,callback){
        rowIndex = 0;
        var data = $("#fm_rule").serializeObject();
        data.pageNo = dataTableData.start / dataTableData.length + 1;
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
                    // console.info(responeData.list);
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


    $().ready(function() {
        $('#tab_rule').DataTable(options);
    });

    //触发查询
    $("#queryRule").click(function () {
        $('#tab_rule').DataTable(options);
    });

    /**
     * 删除
     * @param id
     */
    function del(id){
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


    /**
     * 修改前，加载展示数据
     * @param rowIndex  记录所在行号
     */
    function preEdit(rowIndex) {
        $("#editDIV").show();
        var row = $("#tab_rule tr:eq("+rowIndex+")");

        var id,country,appPkg,conditions,priority,validstatus,init,popuptimes,actionType,linkUrl,packageName,title,message,iconUrl;
        var bigImageUrl,nativeImageUrl;
        var rowData = row.children();
        id = rowData.eq(0).text();
        country = rowData.eq(1).text();
        appPkg = rowData.eq(2).text();
        conditions = rowData.eq(3).text();
        priority = rowData.eq(4).text();
        validstatus = rowData.eq(5).text();
        init = rowData.eq(6).text();
        popuptimes = rowData.eq(7).text();
        actionType = rowData.eq(8).text();
        linkUrl = rowData.eq(9).text();
        packageName = rowData.eq(10).text();
        title = rowData.eq(11).text();
        message = rowData.eq(12).text();
        iconUrl = rowData.eq(13).text();
        bigImageUrl = rowData.eq(14).text();
        nativeImageUrl = rowData.eq(15).text();

        $("#fm_edit #id").val(id);
        $("#fm_edit #country").val(country);
        $("#fm_edit #appPkg").val(appPkg);
        $("#fm_edit #conditions").val(conditions);
        $("#fm_edit #priority").val(priority);
        $("#fm_edit #validstatus").val(validstatus);
        $("#fm_edit #init").val(init);
        $("#fm_edit #popuptimes").val(popuptimes);
        $("#fm_edit #actionType").val(actionType);
        $("#fm_edit #linkUrl").val(linkUrl);
        $("#fm_edit #packageName").val(packageName);
        $("#fm_edit #title").val(title);
        $("#fm_edit #message").val(message);
        $("#fm_edit #iconUrl").val(iconUrl);
        $("#fm_edit #bigImageUrl").val(bigImageUrl);
        $("#fm_edit #nativeImageUrl").val(nativeImageUrl);
        /*只要是修改：缓存状态就需要置为0，以便后续批量初始化*/
        $("#fm_edit #init").val(0);
        //$("#fm_edit #init").val(init);
    }

    /**
     * 关闭弹出层
     */
    $(".closeBtn").click(function (thizz) {
        $("#editDIV").css('display','none');
    });


    /**
     * 更新/修改
     */
    $("#edit").click(function () {
        var url = "${ctx}/appPromotionConfig/updateAppRule";
        var data = $("#fm_edit").serializeObject();
        $.ajax({
            url: url,
            type:"post",
            data:JSON.stringify(data),
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success: function (result) {
                if(ResponseCode.success === result.resultCode){
                    alert("修改成功!");
                    //TODO 刷新数据表格
                    //$("#tab_resource").DataTable().fnDraw(false);
                }
            },
            error:AJAXerror
        });
        return false;
    });

</script>
</html>
