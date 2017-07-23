
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../../styles/normalize.css">
  <link rel="stylesheet" href="../../styles/stylesAdmin.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
  <script src="../../js/jquery-3.2.1.js"></script>
  <script src="../../js/menu.js"></script>
  <title>Страница ошибки</title>
</head>
<body>
<div id="wrapper">
  <header>
    <img id="logo" src="../../images/logo2.png" alt="Logo">
    <form name="sign" action="epam.bookticket.web.BaseServletController" method="get">
      <%request.setCharacterEncoding("UTF-8");%>
      <h2>Вы зашли под записью: <%= session.getAttribute("adminname")%></h2>
      <input type="hidden" name="controllerName" value="SignOut">
      <button name="button_sign">Выйти</button>
    </form>
  </header>
  <aside>
    <nav>
      <ul class="top-menu">
        <form name="page" id="mainPage" action="epam.bookticket.web.BaseServletController" method="get">
          <input type="hidden" name="controllerName" value="PersonalPage">
          <li><a href="#" onclick="mainPage()">Главная</a> </li>
        </form>
        <form name="form" id="adminAddUser" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="AdminAddUser">
          <li><a href="#" onclick="adminAddUser()">Добавить клиента</a></li>
        </form>
        <form name="form" id="seeAllUsers" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="SeeAllUsers">
          <li><a href="#" onclick="seeAllUsers()">Управление клиентами</a></li>
        </form>
        <form name="formAddM" id="addMovieAdmin" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="AddMovieAdmin">
          <li><a href="#" onclick="addMovieAdmin()">Добавить фильм</a></li>
        </form>
        <form name="formChange" id="changeMovie" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="////">
          <li><a href="//">Изменить данные о фильмах</a></li>
        </form>
        <form name="form" id="benefitSystem" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="BenefitSystem">
          <li><a href="#" onclick="benefitSystem()">Скидочная система</a></li>
        </form>
      </ul>
    </nav>
  </aside>
  <section>
    <img id="error" src="../../images/error.jpg" alt="Error">
    <br>
    <h3> <%request.setCharacterEncoding("UTF-8");%>
      <%= request.getAttribute("error")%></h3>
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

