<%@ page
    language="java"
    import="java.util.*"
    contentType="text/html; charset=utf-8"%>
<%@ page
    import="pers.lu.common.model.Good"
%>
<% 
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; 
%>
<%@
    taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core"
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%= basePath %>">
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    <style type="text/css">
        div {
         float: left;
         margin: 10px;
        }
        
        div dd {
         margin: 0px;
         font-size: 10pt;
        }
        
        div dd.dd_name {
         color: blue;
        }
        
        div dd.dd_city {
         color: #000;
        }
    </style>
</head>
<body>
    <h1>商品展示</h1>
    <hr />
    <center>
        <table width="750" height="60" cellpadding="0" cellspacing="0"
            border="0">
            <tr>
                <th width="6%">id</th>
                <th width="82%">商品名</th>
                <th width="12%">操作</th>
            </tr>

            <c:if test="${!empty goodList.List }">
                <c:forEach items="${goodList.List }" var="good">
                <tr>
                    <td style="text-align:left;">
                        <c:out value="${good.id }" default=""></c:out>
                    </td>
                    <td style="text-align:left;">
                        ${good. }
                    </td>
                    
                    <td style="text-align:left;">
                        &nbsp;&nbsp;<a href="">加入购物车</a>
                    </td>

                    <!-- 商品循环结束 -->
                    </td>
                </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty goodList.List }">
                <tr>
                    <td style="text-align:left;">暂无数据记录！</td>
                </tr>
            </c:if>
        </table>
    </center>
</body>
</html>