    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <c:set var="ctx" value="${pageContext.request.contextPath}"/>

    <%--最根本的jsp页面，用于定义引入基本的js和css--%>
    <%--<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />--%>
    <script type="text/javascript" language="JavaScript" src="${ctx}/statics/js/jquery-3.3.1.min.js"></script>
    <script src="${ctx}/statics/js/jquery-ui/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="${ctx}/statics/js/jquery-ui/jquery-ui.min.css"/>
    <link rel="stylesheet" href="${ctx}/statics/js/jquery-ui/jquery-ui.theme.min.css"/>
    <link rel="stylesheet" href="${ctx}/statics/js/jquery-ui/jquery-ui.structure.min.css"/>

    <script src="${ctx}/statics/js/jquery.form.js"></script>
    <script src="${ctx}/statics/js/jquery-validation/jquery.validate.min.js"></script>

    <script type="text/javascript">
        var contextRootPath = "${ctx}";
    </script>
