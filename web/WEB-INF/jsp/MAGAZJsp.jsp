
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .layer {
            border:solid 1px black;
            align:"center";
            table-layout: fixed;
            overflow:hidden;
            width:85%;}
        @media screen and (max-width: 1280px) { div.contentblock {width: 1200px;} }
        @media screen and (max-width: 1140px) { div.contentblock {width: 1024px;} }
        @media screen and (max-width: 992px) { div. contentblock {width: 970px;} }

    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/magaz" method="post">
<TABLE class="layer"   >
    <TR >
        <TD style="width: 100px;">ПРОДУКТ</TD><TD style="width: 50px;">ВЕС/ФАСОВКА
    </TD>
        <TD style="width: 50px;">ЦЕНА</TD><TD style="width: 50px;">ПРОИЗВОДИТЕЛЬ</TD>
        <TD style="width: 20px;">КУПИТЬ</TD>
    </TR>
</TABLE >
<c:forEach var="product" items="${requestScope.product}">
    <p>
    <TABLE class="layer" >
    <TR >
        <TD style="width: 100px;">${product.name}</TD><TD style="width: 50px;">${product.dimId}</TD>
        <TD style="width: 50px;">${product.price}</TD><TD style="width: 50px;">${product.remark}</TD>
        <TD style="width: 20px;"><input type="checkbox" name="rootid" value="${product.rootId}"></TD>
    </TR>
    </TABLE >
    </p>
</c:forEach>
    <input type="submit" value="КУПИТЬ">
    </form>
</body>
</html>
