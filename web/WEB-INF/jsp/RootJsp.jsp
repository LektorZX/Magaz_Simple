<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<HTML>
<HEAD>
    <META charset="utf-8">

    <H1>Здравствуйте!</H1>
    <P><br>
        <STRONG>Выберите действие</STRONG>
    </P>
</HEAD>
<BODY>
<td valign="top">
    <form action="${pageContext.request.contextPath}/root" method="post">

        <label>
            <input type="radio" name="this" value="войти" checked >
            войти
        </label><br>
        <label>
            <input type="radio" name="this" value="регистрация" checked >
            регистрация
        </label><br>
        <input type="submit" value="Отправить">

    </form>
</td>
</BODY>
</HTML>