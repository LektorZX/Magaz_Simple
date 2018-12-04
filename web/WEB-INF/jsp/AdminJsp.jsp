<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<HTML>
<HEAD>
    <META charset="utf-8">

    <H1>Здравствуйте ADMIN!</H1>
    <P><br>
        <STRONG>Выберите действие</STRONG>
    </P>
</HEAD>
<BODY>
<td valign="top">
    <form action="${pageContext.request.contextPath}/admin" method="post">

        <label>
            <input type="radio" name="this" value="ДОБАВИТЬ ТОВАР" checked >
            ДОБАВИТЬ ТОВАР
        </label><br>
        <label>
            <input type="radio" name="this" value="ПОКАЗАТЬ ВСЕ ТОВАРЫ В БАЗЕ" checked >
            ПОКАЗАТЬ ВСЕ ТОВАРЫ В БАЗЕ
        </label><br>
        <label>
            <input type="radio" name="this" value="УДАЛИТЬ ТОВАР ИЗ БАЗЫ" checked >
            УДАЛИТЬ ТОВАР ИЗ БАЗЫ
        </label><br>
        <label>
            <input type="radio" name="this" value="ПОКАЗАТЬ ЗАРЕГЕСТРИРОВАНЫХ ПОЛЬЗОВАТЕЛЕЙ" checked >
            ПОКАЗАТЬ ЗАРЕГЕСТРИРОВАНЫХ ПОЛЬЗОВАТЕЛЕЙ
        </label><br>
        <label>
            <input type="radio" name="this" value="УДАЛИТЬ ЗАПИСЬ О ПОЛЬЗОВАТЕЛЕ" checked >
            УДАЛИТЬ ЗАПИСЬ О ПОЛЬЗОВАТЕЛЕ
        </label><br>
        <label>
            <input type="radio" name="this" value="ДОБАВИТЬ ЗАПИСЬ О ПОЛЬЗОВАТЕЛЕ" checked >
            ДОБАВИТЬ ЗАПИСЬ О ПОЛЬЗОВАТЕЛЕ
        </label><br>
        <label>
            <input type="radio" name="this" value="выход" checked >
            ВЫХОД
        </label><br>
        <label>
            <input type="radio" name="this" value="назад" checked >
            НАЗАД
        </label><br>
        <input type="submit" value="ДАЛЕЕ">

    </form>
</td>
</BODY>
</HTML>