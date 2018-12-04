<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<HTML>
<HEAD>
    <META charset="utf-8">
    <style>
        .layer {
            border:solid 1px black;
            align:"center";
            table-layout: fixed;
            overflow:hidden;
            width:35%;}
        @media screen and (max-width: 1280px) { div.contentblock {width: 1200px;} }
        @media screen and (max-width: 1140px) { div.contentblock {width: 1024px;} }
        @media screen and (max-width: 992px) { div. contentblock {width: 970px;} }

    </style>
    <P>
        <STRONG>ПРОСМОТР ПОЛЬЗОВАТЕЛЕЙ В БАЗЕ</STRONG>
    </P>
</HEAD>
<BODY>
<form action="${pageContext.request.contextPath}/seeUser" method="post">
    <TABLE class="layer">
        <TR >
            <TD style="width: 50px;">id</TD><TD style="width: 50px;">name</TD>
            <TD style="width: 50px;">mail</TD><TD style="width: 50px;">status</TD>
        </TR>
    </TABLE >
    <c:forEach var="users" items="${requestScope.users}">
        <p>
        <TABLE class="layer">
            <TR >
                <TD style="width: 50px;">${users.id}</TD><TD style="width: 50px;">${users.name}</TD>
                <TD style="width: 50px;">${users.mail}</TD><TD style="width: 50px;">${users.status}</TD>
            </TR>
        </TABLE >
        </p>
    </c:forEach>
    <div>
        <br>
        <input type="submit" value="НАЗАД" name="flag"/>
    </div>
</form>
</BODY>
</HTML>
