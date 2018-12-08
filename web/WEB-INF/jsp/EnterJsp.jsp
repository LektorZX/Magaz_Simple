<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<HTML>
<HEAD>
    <META charset="utf-8">
    <style type="text/css">
        body {font-size:14px;}
        label {float:left; padding-right:10px;}
        .field {clear:both; text-align:right; line-height:25px;}
        .main {float:left;}
    </style>

</HEAD>
<BODY>

<%@include file="header.jsp"%>
<H1><fmt:message key="Hello" /></H1> <!--Заголовок страницы -->
<!-- начало тела документа -->
<P>
    <DEL>
        <EM><fmt:message key="Del" /></EM>
    </DEL><br>
    <STRONG><fmt:message key="userSubmit" /></STRONG>
</P>
<form action="${pageContext.request.contextPath}/enter" method="post">
    <div class="main">
        <div class="field">
            <label><fmt:message key="userName" /></label>
            <input type="text" name="name" required autofocus placeholder="Вася Пупкин"/>
        </div>
        <div class="field">
            <label><fmt:message key="userMail" /> </label>
            <input type="text" name="mail" placeholder="12345@mail.by"/>
        </div>
        <div class="field">
            <form >
                <label><fmt:message key="userStatus" /></label>
                <TR>
                    <TD rowspan="2">
                        <input list="text" name="status">
                        <datalist id="text">
                            <option value="1">client</option>
                            <option value="2">admin</option>
                        </datalist>
                    </TD>
                </TR>
                </TABLE>
                </label><br>
            </form>
        </div>
        <input type="submit" value="<fmt:message key="userSubmit"/>">
    </div>
</form>
</BODY>
</HTML>
