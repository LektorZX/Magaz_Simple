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
        <STRONG>Регистрация пользователя</STRONG>
    </P>
</HEAD>
<BODY>
<form action="${pageContext.request.contextPath}/addUser" method="post">
    <div class="main">
        <div class="field">
            <label>ФИО: </label>
            <input type="text" name="name"  autofocus placeholder="Вася Пупкин"/>
        </div>
        <div class="field">
            <label>МЫЛО: </label>
            <input type="text" name="mail" placeholder="12345@mail.by"/>
        </div>
        <div class="field">
            <form >
                <label>СТАТУС:</label>
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
        <input type="submit" value="Добавить в базу" name="flag" />
        <input type="submit" value="Отмена" name="flag" />
    </div>
</form>
</BODY>
</HTML>