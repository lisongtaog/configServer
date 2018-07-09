<%--
  Created by IntelliJ IDEA.
  User: Xixi
  Date: 2018/7/6
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="pages/common/rootBase.jsp"%>
<html>
<head>
    <title>Config Server Index</title>
    <style>
        #nav{
            position:fixed;
            height: 15%;
            width:100%;
            float:top;
        }
        iframe{
            height:100%;
            width:100%;
            overflow-x:hidden;
        }
    </style>
</head>
<body>
<div id="nav">
    <nav class="navbar navbar-default nav-stacked">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                </button>
                <a class="navbar-brand glyphicon glyphicon-home active" href="index.html" target="theFrame"></a>
            </div>
            <div class="container-fluid col-md-11">
                <%--<div>
                    <div class="col-lg-6">
                        <form class="navbar-form navbar-left" method="post" action="appPromotionConfig/queryResource" enctype="multipart/form-data">
                            <div class="form-group">
                                <input type="text" class="form-control" name="appPkg" placeholder="Resource">
                                <input type="text" class="form-control" name="country" value="US">
                            </div>
                            <input class="btn btn-default" type="submit" value="配置查询"/>
                        </form>
                    </div>
                    <div class="col-lg-6">
                        <form class="navbar-form navbar-left" method="post" action="appPromotionConfig/queryRule" enctype="multipart/form-data">
                            <div class="form-group">
                                <input type="text" class="form-control" name="appPkg" value="com.example.demo.goods">
                                <input type="text" class="form-control" name="country" value="US">
                            </div>
                            <input class="btn btn-default" type="submit" value="规则查询"/>
                        </form>
                    </div>
                </div>
--%>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="pages/config/listResource.jsp" target="theFrame">查询资源</a></li>
                        <li><a href="pages/config/listRule.jsp" target="theFrame">查询规则</a></li>
                        <li><a href="pages/config/configResource.jsp" target="theFrame">新增资源</a></li>
                        <li><a href="pages/config/configRule.jsp" target="theFrame">新增规则</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">增量刷新<span
                                    class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="appPromotionConfig/incrResource" target="theFrame">增量刷新Resource包</a></li>
                                <li><a href="appPromotionConfig/incrRule" target="theFrame">增量刷新规则</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>
<div style="height:100%;width:100%;padding: 60px 10px 5px 10px;">
    <iframe src="index.html" name="theFrame" frameborder="0" scrolling="auto"></iframe>
</div>
</body>
</html>
