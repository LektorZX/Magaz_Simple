<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<HTML>
<HEAD>
    <META charset="utf-8">
    <style type="text/css">
        body {font-size:14px;}
        label {float:left; padding-right:10px;}
        .field {clear:both; text-align:right; line-height:25px;}
        .main {float:left;}
    </style>
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
        <STRONG>УДАЛЕНИЕ ПОЛЬЗОВАТЕЛЯ ИЗ БАЗЫ</STRONG>
    </P>
</HEAD>
<BODY>
<form>
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
</form>
<form action="${pageContext.request.contextPath}/delUser" method="post">
    <div class="main">
        <div class="field">
            <label>ВВЕДИТЕ Id ПОЛЬЗОВАТЕЛЯ </label>
            <input type="text" name="UserId" autofocus placeholder="12345"/>
        </div>
        <div>
            <br>
            <input type="submit" value="Удалить из базы" name="flag" />
            <input type="submit" value="Отмена" name="flag" />
        </div>
    </div>
</form>
</BODY>
</HTML>
