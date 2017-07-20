<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles/login.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
    <title>Вход в систему</title>
</head>
<body>
<br>
<h1>Вход в систему</h1>
<form action="classes.web.BaseServletController" method="post" name="registration">
    <input type="hidden" name="controllerName" value="Registration">
    <br>Пользователь:</br>
    <input type="text" name="user" required>
    <br>Пароль:</br>
    <input type="password" name="password" required>
    <br>
    <br>
    <input type="submit" name="login" value="Войти в систему">
    <input type="submit" name="registration" value="Зарегистрироваться">
</form>
<br>
</body>
</html>