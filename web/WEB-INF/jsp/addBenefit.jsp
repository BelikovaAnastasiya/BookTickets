<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../../styles/normalizeR.css">
  <link rel="stylesheet" href="../../styles/stylesR.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
  <title>Добавление нового типа скидки</title>
</head>
<body>
<div id="wrapper">
  <header>
    <img id="logo" src="../../images/logo2.png" alt="Logo">
  </header>
  <section>
    <form name="add" action="epam.bookticket.web.BaseServletController" method="get">
      <input type="hidden" name="controllerName" value="SaveNewBenefit">
      <div class="block">
        <p>Тип скидки: <input type="text" name="title" required></p>
        <p>Размер: <input name="size" type="number" min="1" max="100" required></p>
      </div>
      <div class="buttons">
        <input type="submit" name="save" value="Сохранить">
        <input type="reset" onclick="onreset(this.form)" value="Очистить">
      </div>
    </form>
    <form action="epam.bookticket.web.BaseServletController" method="get">
      <input type="hidden" name="controllerName" value="PersonalPage">
      <div class="block2"> <input type="submit" name="cancel" value="Выйти"></div>
    </form>
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
