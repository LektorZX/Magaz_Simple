<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <META charset="utf-8">
    <style type="text/css">
        body {font-size:14px;}
        label {float:left; padding-right:3px;}
        .field {clear:both; text-align:right; line-height:20px;}
        .main {float:left;}
    </style>
    <P>
        <STRONG>ДОБАВИТЬ ТОВАР</STRONG>
    </P>
</HEAD>
<BODY>
<form action="${pageContext.request.contextPath}/AdminNewProduct" method="post">
    <div class="main">
        <div class="field">
            <input type="text" name="RootId"  autofocus placeholder="12345"/>
            <label>RootId </label>
        </div>
        <div class="field">
            <label>Name </label>
            <input type="text" name="Name" autofocus placeholder="абвгд"/>
        </div><div class="field">
        <label>Dimid </label>
        <input type="text" name="Dimid"  autofocus placeholder="КГ"/>
    </div><div class="field">
        <label>Price </label>
        <input type="text" name="Price" autofocus placeholder="12345"/>
    </div><div class="field">
        <label>GroupId </label>
        <input type="text" name="GroupId"  autofocus placeholder="12345"/>
    </div><div class="field">
        <label>Weight </label>
        <input type="text" name="Weight"  autofocus placeholder="12345"/>
    </div><div class="field">
        <label>PostName </label>
        <input type="text" name="PostName"  autofocus placeholder="Алеся"/>
    </div><div class="field">
        <label>Remark </label>
        <input type="text" name="Remark"  autofocus placeholder="РБ"/>
    </div>
        <div class="field">
            <br>
            <input type="submit" value="Внести в базу" name="flag" />
            <input type="submit" value="Отмена" name="flag" />
        </div>
    </div>
</form>
</BODY>
</HTML>