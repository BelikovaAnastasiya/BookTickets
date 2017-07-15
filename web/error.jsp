<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles/login.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
    <title>Страница ошибки</title>
</head>
<body>
<div id="wrapper">
    <header>
        <img id="logo" src="images/logo2.png" alt="Logo">
    </header>
    <section>
        <img id="error" src="images/error.jpg" alt="Error">
        <br>
        <h3> <%request.setCharacterEncoding("UTF-8");%>
            <%= request.getAttribute("error")%></h3>
    </section>
</div>
<footer>
    <div id="footer">
        <div id="sitemap">
            <h2>Сайт</h2>
            <div>
                <a href="/buy/">Купить билет</a>
                <a href="/cinema/">Кинотеатры</a>
            </div>
            <div>
                <a href="/see/">Афиша</a>
                <a href="/about/">О нас</a>
            </div>
        </div>
        <div id="contact">
            <h2>Контакты</h2>
            <p>Головной офис: г.Минск, ул. Калиновского 62; </p>
            <p>Заказ и бронирование билетов: +375292304156, +375442162389</p>
        </div>
    </div>
</footer>
</body>
</html>