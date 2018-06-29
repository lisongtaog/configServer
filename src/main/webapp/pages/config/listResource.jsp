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

        <input type="button" value="查询" id="submit"/>
    </form>
</div>

<div id="editDIV" class="float" style="display: none;z-index: 9999;">
    <button class="closeBtn" style="float: right;">关闭</button>
    <form id="fm_edit" style="margin:50px 100px;">
        <label for="id">主&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;键</label>
        <input type="text" id="id" name="id"/><br/>


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
        </select><br/>

        <label for="appPkg">资源包&nbsp;&nbsp;</label>
        <input id="appPkg" name="appPkg"></input><br/>

        <label for="validstatus">有效状态</label>
        <select id="validstatus" name="validstatus">
            <option value="1">有效</option>
            <option value="0">无效</option>
        </select><br/>

        <label for="init">初始化状态</label>
        <select id="init" name="init">
            <option value="1">已初始化</option>
            <option value="0">未初始化</option>
        </select><br/><br/>

        <input type="submit" value="提交" id="submit"/>
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
        { "data": "appType"},
        { "data": "appPkg"},
        { "data": "appName"},
        { "data": "validstatus"},
        { "data": "init"},
        { "data": "createTime"},
        { "data": "updateTime"},
        { "data": "operate"}
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
                    var html ='<button onclick="edit('+ row.id + ')">编辑</button>&nbsp;&nbsp;'
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
        var data = $("#fm_resource").serializeObject();
        data.pageNo = dataTableData.start / dataTableData.length;
        data.pageSize = dataTableData.length;

        var url = "${ctx}/appPromotionConfig/listResource";
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

    $().ready(function() {
        $('#tab_resource').DataTable(options);
    });

    //触发查询
    $("#submit").click(function () {
        $('#tab_resource').DataTable(options);
    });

    /**
     * 删除
     * @param id
     */
    function del(id){
        alert(id);
        var url = "${ctx}/appPromotionConfig/deleteAppResource";
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
     * 修改
     * @param thizz
     */
    function edit(id) {
        $("#editDIV").show();

        //查询详情展示，然后再修改更新；
        var url = "";
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
        //console.info(rowData);
    }

    /**
     * 关闭弹出层
     */
    $(".closeBtn").click(function (thizz) {
        $("#editDIV").css('display','none');
    });

</script>
</html>
