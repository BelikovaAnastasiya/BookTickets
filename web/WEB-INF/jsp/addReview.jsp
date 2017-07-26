<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../../styles/normalizeR.css">
  <link rel="stylesheet" href="../../styles/stylesAdd.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
  <script src="../../js/jquery-3.2.1.js"></script>
  <script src="../../js/menu.js"></script>
  <title>Добавление нового отзыва</title>
</head>
<body>
<div id="wrapper">
  <header>
    <img id="logo" src="../../images/logo2.png" alt="Logo">
  </header>
  <aside>
    <nav>
      <ul class="top-menu">
        <form name="page" id="mainPage" action="epam.bookticket.web.BaseServletController" method="get">
          <input type="hidden" name="controllerName" value="PersonalPage">
          <li><a href="#" onclick="mainPage()">Главная</a> </li>
        </form>
        <form name="form" id="bookticket" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="BookTicket">
          <li><a href="#" onclick="bookTicket()">Заказать билет</a></li>
        </form>
        <form name="form" id="booking" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="SeeBooking">
          <li><a href="#" onclick="booking()" >Мои заказы</a></li>
        </form>
        <form name="form" id="reviews" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="SeeReviews">
          <li><a href="#" onclick="reviews()">Мои рецензии</a></li>
        </form>
        <form name="form" id="movies" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="AllMovies">
          <li><a href="#" onclick="movies()">Афиша</a></li>
        </form>
        <form name="form" id="review" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="AddReview">
          <li><a href="#" onclick="review()">Написать отзыв</a></li>
        </form>
        <form name = "form" id="profile" action="epam.bookticket.web.BaseServletController" method="get">
          <input type="hidden" name="controllerName" value="MyProfile">
          <li><a href="#" onclick="profile()">Профиль</a></li>
        </form>
      </ul>
    </nav>
  </aside>
  <section>
    <form name="add" action="epam.bookticket.web.BaseServletController" method="get">
      <input type="hidden" name="controllerName" value="SaveReview">
      <div class="block">
        <p>Название фильма: <input type="text" name="title" required></p>
        <p>Ваша оценка: <input name="rating" type="number" min="1" max="5" required></p>
        <p>Отзыв: <textarea rows="5" cols="45"  name="reviewText"></textarea></p>
      </div>
      <div class="buttons">
        <input type="submit" name="save" value="Сохранить">
        <input type="reset" onclick="onreset(this.form)" value="Очистить">
      </div>
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
