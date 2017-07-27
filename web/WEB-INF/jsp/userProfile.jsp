
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../../styles/normalize.css">
  <link rel="stylesheet" href="../../styles/stylesAdd.css" type="text/css">
  <script src="../../js/jquery-3.2.1.js"></script>
  <script src="../../js/menu.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
  <title>Профиль</title>
  <script>
    var pokazatel_prosmotra = 0;

    function change()
    {
      if (pokazatel_prosmotra == 0) {
        var el = '<html><form name="formChange" id="change" action="epam.bookticket.web.BaseServletController" method="get" ><input type="hidden" name="controllerName" value="ChangeProfile"> <br>Выберите: <select name="param" required><option value="" disabled selected >Изменяемое поле</option><option value="login">Логин</option><option value="password">Пароль</option><option value="mail">E-mail</option><option value="name">Имя</option><option value="surname">Фамилия</option><option value="numberCreditCard">Номер карты</option><option value="phone">Телефон</option></select><p></p> Введите новое значение: <input name="value" type="text" required ><input type="submit" name="ch" value="Изменить"></form></html>';
        $(el).appendTo("#info");
        pokazatel_prosmotra = 1;
      }
      else
      {
        $('#info').remove();
        pokazatel_prosmotra = 0;
      }
    }
  </script>
</head>
<body>
<div id="wrapper">
  <header>
    <img id="logo" src="../../images/logo2.png" alt="Logo">
    <form name="sign" action="epam.bookticket.web.BaseServletController" method="get">
      <%request.setCharacterEncoding("UTF-8");%>
      <h2>Вы зашли под записью: <%= session.getAttribute("username")%></h2>
      <input type="hidden" name="controllerName" value="SignOut">
      <button name="button_sign">Выйти</button>
    </form>
  </header>
  <aside>
    <nav>
      <ul class="top-menu">
        <form name="form" id="mainPage" action="epam.bookticket.web.BaseServletController" method="get">
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
     <br>
      <hr>
      <p>Логин: <%=request.getAttribute("login")%></p>
      <p>Пароль: <%=request.getAttribute("password")%></p>
      <p>E-mail: <%=request.getAttribute("mail")%></p>
      <p>Имя: <%=request.getAttribute("name")%></p>
      <p>Фамилия: <%=request.getAttribute("surname")%></p>
      <p>Номер кредитной карты: <%=request.getAttribute("numberCreditCard")%></p>
      <p>Телефон: <%=request.getAttribute("phone")%></p>
      <p>Размер скидки: <%=request.getAttribute("benefit")%>%</p>
      <hr>
    <form name = "form" id="change" action="epam.bookticket.web.BaseServletController" method="get">
      <input type="hidden" name="controllerName" value="ChangePage">
      <input name="changeInf" type="button" onclick="change()" value="Изменить данные">
      <div id="info"></div>
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

