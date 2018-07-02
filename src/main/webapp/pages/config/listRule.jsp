<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/rootBase.jsp"%>
<html>
<head>
    <title>查询推广规则</title>
</head>
<body>
<div class="container">
    <fieldset>
        <legend>规则配置查询</legend>
        <form id="fm_rule" class="form-horizontal" role="form">
            <div class="form-group">
                <label for="appPkg" class="col-md-2 control-label">应用包</label><%--可配置DEFAULT--%>
                <div class="col-sm-3">
                    <input type="text" id="appPkg" name="appPkg" class="form-control"/>
                </div>

                <label for="country" class="col-md-1 control-label">国家</label><%--可配置DEFAULT--%>
                <div class="col-sm-2">
                    <input type="text" id="country" name="country" class="form-control"/>
                </div>
                <%--后续读取数据库配置，下拉框展示 --%>
                <%--<select name="country" id="country">
                    <option value="DEFAULT">默认</option>
                    <option value="US">美国</option>
                    <option value="AU">澳大利亚</option>
                    <option value="CA">加拿大</option>
                    <option value="GB">德国</option>
                </select>--%>
                <div class="col-sm-2">
                    <input type="button" value="查询" id="queryRule" class="btn btn-info"/>
                </div>
            </div>
        </form>
    </fieldset>
</div>

<div class="modal fade" id="editDIV" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改规则</h4>
            </div>
            <div class="modal-body"><%--form-horizontal--%>
                <form id="fm_edit" class="form-horizontal" role="form">
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
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
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
                        <div class="col-sm-10">
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
                        <div class="col-sm-10">
                            <textarea id="comments" name="comments" rows="3" cols="20" class="form-control"></textarea>
                        </div>
                    </div>
            </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
                </button>
                <button type="button" id="btn_edit" class="btn btn-primary" data-dismiss="modal">
                    <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>提交
                </button>
                <%--<input type="submit" value="提交" id="btn_edit"/>--%>
            </div>
        </div>
    </div>
</div>

<div>
    <table id="tab_rule" class="cell-border stripe">
        <thead>
        <tr>
            <th>ID</th>
            <th>国家</th>
            <th>宿主<br/>应用包</th>
            <th>条件</th>
            <th>优先级</th>
            <th>有效状态</th>
            <th>缓存状态</th>
            <th>广告弹出次数</th>
            <th>响应类型</th>
            <th>推广链接</th>
            <th>推广<br/>应用包</th>
            <th>Tittle</th>
            <th>Message</th>
            <th>icon</th>
            <th>BigImage</th>
            <th>NativeImage</th>
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
        { "data": "id","orderable":false,"width":"20px"},
        { "data": "country","width":"60px" },
        { "data": "appPkg"},
        { "data": "conditions"},
        { "data": "priority","width":"35px"},
        { "data": "validstatus"},
        { "data": "init"},
        { "data": "popuptimes"},
        { "data": "actionType","width":"35px"},
        { "data": "linkUrl"},
        { "data": "packageName"},
        { "data": "title"},
        { "data": "message"},
        { "data": "iconUrl"},
        { "data": "bigImageUrl"},
        { "data": "nativeImageUrl"},
        { "data": "createTime"},
        { "data": "updateTime"},
        { "data": "operate","width":"30px"}
    ];
    var options = {
        "searching": false,// 是否允许检索
        "ordering":false,
        "info": true,// 是否显示情报 就是"当前显示1/100记录"这个信息
        "serverSide": true,//服务器端分页
        "paging": true,// 是否允许翻页，设成false，翻页按钮不显示
        "scrollX": true,// 水平滚动条
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
                    var html ='<a href="javascript:void(0);" class="link_modify glyphicon glyphicon-pencil" onclick="preEdit('+ row.id + ')"></a>&nbsp;&nbsp;'
                        +'<a href="javascript:void(0);" class="link_delete glyphicon glyphicon-remove" onclick="del('+ row.id + ')"></a>';
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
        var poupMsg = confirm("确定删除吗？");
        if(poupMsg){
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
        }
    };


    /**
     * 修改前，加载展示数据
     * @param   id 规则
     */
    function preEdit(id) {
        $('#editDIV').modal();
        var url = "${ctx}/appPromotionConfig/detailRule";
        $.ajax({
            url: url,
            type:"post",
            data:"id="+ id,
            dataType:"json",
            success: function (result) {
                if(ResponseCode.success === result.resultCode){
                    var rule = result.resultObj;

                    $("#fm_edit #id").val(rule.id);
                    $("#fm_edit #country").val(rule.country);
                    $("#fm_edit #appPkg").val(rule.appPkg);
                    $("#fm_edit #conditions").val(rule.conditions);
                    $("#fm_edit #priority").val(rule.priority);
                    $("#fm_edit #validstatus").val(rule.validstatus);
                    $("#fm_edit #init").val(rule.init);
                    $("#fm_edit #popuptimes").val(rule.popuptimes);
                    $("#fm_edit #actionType").val(rule.actionType);
                    $("#fm_edit #linkUrl").val(rule.linkUrl);
                    $("#fm_edit #packageName").val(rule.packageName);
                    $("#fm_edit #title").val(rule.title);
                    $("#fm_edit #message").val(rule.message);
                    $("#fm_edit #iconUrl").val(rule.iconUrl);
                    $("#fm_edit #bigImageUrl").val(rule.bigImageUrl);
                    $("#fm_edit #nativeImageUrl").val(rule.nativeImageUrl);
                    $("#fm_edit #comments").val(rule.comments);
                    /*只要是修改：缓存状态就需要置为0，以便后续批量初始化*/
                    $("#fm_edit #init").val(0);
                    //TODO 刷新数据表格
                    //$("#tab_resource").DataTable().fnDraw(false);
                }
            },
            error:AJAXerror
        });
    }

    /**
     * 更新/修改
     */
    $("#btn_edit").click(function () {
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
