<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04-Jul-17
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="styles/normalize.css">
  <link rel="stylesheet" href="styles/styles.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
  <title>Поиск фильма</title>
</head>
<body>
<div id="wrapper">
  <header>
    <img id="logo" src="images/logo2.png" alt="Logo">
    <form name="sign" action="login.html" method="get">
      <button name="button_sign">Войти</button>
    </form>
    <form name="search" action="classes.web.FindFilm" method="get">
      <input type="text" name="search" placeholder="Поиск фильма"><button type="submit">Ок</button>
    </form>
  </header>
  <nav>
    <ul class="top-menu">
      <li><a href="/buy/">Как купить билет?</a></li>
      <li><a href="/cinema/">Кинотеатры</a></li>
      <li><a href="/see/">Афиша</a></li>
      <li><a href="/about/">О нас</a></li>
    </ul>
  </nav>
  <section>
    <c:forEach items="${m}" var="movie">
      <p>Название фильма: ${movie.title}</p>
      <p>Год выпуска: ${movie.yearOfProduction}</p>
      <p>Жанр: ${movie.type}</p>
      <p>Главные роли исполняли: ${movie.mainActors}</p>
      <hr>
    </c:forEach>
  </section>
</div>
<footer>
  <div id="footer">
    <div id="sitemap">
      <h3>Сайт</h3>
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
      <h3>Контакты</h3>
      <p>Головной офис: г.Минск, ул. Калиновского 62; </p>
      <p>Заказ и бронирование билетов: +375292304156, +375442162389</p>
    </div>
  </div>
</footer>
</body>
</html>
