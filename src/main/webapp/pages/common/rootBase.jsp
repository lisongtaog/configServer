    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <%--版本号，防止css、js缓存；定义此版本号--%>
    <c:set var="version" value="1.1"/>

    <%--最根本的jsp页面，用于定义引入基本的js和css--%>
    <link rel="stylesheet" href="${ctx}/statics/css/base.css?v=${version}" />
    <script type="text/javascript" language="JavaScript" src="${ctx}/statics/js/jquery-3.3.1.min.js"></script>
    <script src="${ctx}/statics/js/jquery-ui/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="${ctx}/statics/js/jquery-ui/jquery-ui.min.css"/>
    <link rel="stylesheet" href="${ctx}/statics/js/jquery-ui/jquery-ui.theme.min.css"/>
    <link rel="stylesheet" href="${ctx}/statics/js/jquery-ui/jquery-ui.structure.min.css"/>
    <link rel="stylesheet" href="${ctx}/statics/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${ctx}/statics/bootstrap/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="${ctx}/statics/css/bootstrap-tagsinput.css"/>
    <link rel="stylesheet" href="${ctx}/statics/css/bootstrap-datetimepicker.css"/>


    <script src="${ctx}/statics/js/jquery-3.3.1.min.js"></script>
    <script src="${ctx}/statics/js/jquery-ui/jquery-ui.min.js"></script>
    <script src="${ctx}/statics/js/jquery.form.js"></script>
    <script src="${ctx}/statics/js/jquery-validation/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="${ctx}/statics/js/datatables/datatables.min.css" />
    <script src="${ctx}/statics/js/datatables/datatables.min.js"></script>

    <script src="${ctx}/statics/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx}/statics/bootstrap/js/bootstrap-datetimepicker.js"></script>

    <script type="text/javascript">
        var contextRootPath = "${ctx}";
        var ResponseCode = {
            "success":"0000",
            "error":"9999"
        }

        //操作类型
        var Operate = {
            "view":0,//查看详情
            "edit":1 //编辑修改
        }
        $.fn.serializeObject = function()
        {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function() {
                if (o[this.name] !== undefined) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
        
        
        function  AJAXerror (XMLHttpRequest, textStatus, errorThrown) {
            console.log(XMLHttpRequest.status);// 状态码
            console.log(XMLHttpRequest.readyState);// 状态
            console.log(textStatus);// 错误信息
        }

        //jquery datatable 异常事件处理；取消弹窗警告
        //开发过程中 可以放开进行调试
        $.fn.dataTable.ext.errMode = 'none';

    </script>
