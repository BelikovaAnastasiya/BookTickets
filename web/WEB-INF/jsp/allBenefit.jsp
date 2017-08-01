<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../../styles/normalize.css">
  <link rel="stylesheet" href="../../styles/stylesAdd.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
  <script src="../../js/jquery-3.2.1.js"></script>
  <script src="../../js/menu.js"></script>
  <title>Скидочная система</title>
  <script>
    var pokazatel_prosmotra = 0;

    function deleteForm()
    {
      if (pokazatel_prosmotra == 0) {
        var el = '<html> <form name="formdelete" id="delete" action="epam.bookticket.web.BaseServletController" method="get" ><input type="hidden" name="controllerName" value="DeleteBenefit">Введите название скидки: <input name="procent" type="text" required ><input type="submit" name="del" value="Удалить"></form></html>';
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
      <h2>Вы зашли под записью: <%= session.getAttribute("adminname")%></h2>
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
        <form name="form" id="adminAddUser" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="AdminAddUser">
          <li><a href="#" onclick="adminAddUser()">Добавить клиента</a></li>
        </form>
        <form name="form" id="seeAllUsers" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="SeeAllUsers">
          <li><a href="#" onclick="seeAllUsers()">Управление клиентами</a></li>
        </form>
        <form name="form" id="addMovieAdmin" action="epam.bookticket.web.BaseServletController" method="get" >
          <input type="hidden" name="controllerName" value="AddMovieAdmin">
          <li><a href="#" onclick="addMovieAdmin()">Добавить фильм</a></li>
        </form>
        <form name="form" id="changeMovie" action="epam.bookticket.web.BaseServletController" method="get" >
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
    <table border="1">
      <tr>
        <td>Тип скидки</td>
        <td>Размер</td>
      </tr>
    <c:forEach items="${benefits}" var="benefit">
      <tr>
      <td>${benefit.typeBenefit}</td>
      <td>${benefit.sizeBenefit}%</td>
      </tr>
    </c:forEach>
    </table>
    <form name="actionBenefit" action="epam.bookticket.web.BaseServletController">
      <input type="hidden" name="controllerName" value="AddBenefit">
      <input name="setUserBenefit" type="submit" value="Назначить клиенту бонус">
      <input name="addBenefit" type="submit" value="Добавить новый тип скидок">
      <input name="deleteBenefit" type="button" onclick="deleteForm()" value="Удалить вид скидок">
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
