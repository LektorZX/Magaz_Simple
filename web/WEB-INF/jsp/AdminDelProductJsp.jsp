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
    <P>
        <STRONG>УДАЛЕНИЕ ТОВАРА ИЗ БАЗЫ</STRONG>
    </P>
</HEAD>
<BODY>
<form action="${pageContext.request.contextPath}/delProduct" method="post">
    <div class="main">
        <div class="field">
            <label>ВВЕДИТЕ RootId ТОВАРА </label>
            <input type="text" name="RootId" autofocus placeholder="12345"/>
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
