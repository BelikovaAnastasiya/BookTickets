<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="styles/normalize.css">
  <link rel="stylesheet" href="styles/stylesPersonal.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
  <script src="js/jquery-3.2.1.js"></script>
  <script src="js/menu.js"></script>
  <title>Мои заказы</title>
</head>
<body>
<div id="wrapper">
  <header>
    <img id="logo" src="images/logo2.png" alt="Logo">
    <form name="sign" action="index.jsp" method="get">
      <%request.setCharacterEncoding("UTF-8");%>
      <h2>Вы зашли под записью: <%= session.getAttribute("username")%></h2>
      <button name="button_sign">Выйти</button>
    </form>
  </header>
  <aside>
    <nav>
      <ul class="top-menu">
        <li><a href="personalPage.jsp">Главная</a> </li>
        <p></p>
        <form name="form" id="bookticket" action="classes.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="BookTicket">
          <li><a href="#" onclick="bookTicket()">Заказать билет</a></li>
        </form>
        <form name="form" id="booking" action="classes.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="SeeBooking">
          <li><a href="#" onclick="booking()" >Мои заказы</a></li>
        </form>
        <form name="form" id="reviews" action="classes.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="SeeReviews">
          <li><a href="#" onclick="reviews()">Мои рецензии</a></li>
        </form>
        <form name="form" id="movies" action="classes.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="AllMovies">
          <li><a href="#" onclick="movies()">Афиша</a></li>
        </form>
        <form name="form" id="review" action="classes.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="AddReview">
          <li><a href="#" onclick="review()">Написать отзыв</a></li>
        </form>
        <form name = "form" id="profile" action="classes.web.BaseServletController" method="get">
          <input type="hidden" name="controllerName" value="MyProfile">
          <li><a href="#" onclick="profile()">Профиль</a></li>
        </form>
      </ul>
    </nav>
  </aside>
  <section>
    <%
      ArrayList str = (ArrayList)request.getAttribute("r");
    for(int i = 0; i<str.size(); i=i+3)
    {
    %>
    <p>Название фильма: <%out.println(str.get(i));%></p>
    <p>Оценка: <%out.println(str.get(i+1));%></p>
    <p>Отзыв: <%out.println(str.get(i+2));%></p>
    <hr>
    <%
    }
    %>
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


