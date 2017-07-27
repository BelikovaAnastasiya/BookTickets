<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
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
  <title>Клиенты</title>
  <script>

    var pokazatel_prosmotra = 0;

    function deleteUser()
    {
      if (pokazatel_prosmotra == 0) {
        var el = '<html> <form name="formDelete" id="delete" action="epam.bookticket.web.BaseServletController" method="get" ><input type="hidden" name="controllerName" value="DeleteUser">Введите логин клиента: <input name="userName" type="text" required ><input type="submit" name="del" value="Удалить"></form></html>';
        $(el).appendTo("#info");
        pokazatel_prosmotra = 1;
      }
      else
      {
        $('#info').remove();
        pokazatel_prosmotra = 0;
      }
    }

    function changeUser()
    {
      if (pokazatel_prosmotra == 0) {
        var el = '<html> <form name="formChange" id="change" action="epam.bookticket.web.BaseServletController" method="get" ><input type="hidden" name="controllerName" value="ChangeUser">Введите логин клиента: <input name="chUserName" type="text" required ><br>Выберите: <select name="param" required><option value="" disabled selected >Изменяемое поле</option><option value="login">Логин</option><option value="password">Пароль</option><p></p> Введите новое значение: <input name="value" type="text" required ><input type="submit" name="del" value="Изменить"></form></html>';
        $(el).appendTo("#info2");
        pokazatel_prosmotra = 1;
      }
      else
      {
        $('#info2').remove();
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
    <table border="1" id="tabl">
      <tr>
        <td>Логин</td>
        <td>Пароль</td>
        <td>E-mail</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Телефон</td>
        <td>Скидка</td>
      </tr>
      <c:forEach items="${users}" var="users">
        <tr>
          <td>${users.login}</td>
          <td> ${users.password}</td>
          <td> ${users.mail}</td>
          <td> ${users.name}</td>
          <td> ${users.surname}</td>
          <td> ${users.phone}</td>
          <td> ${users.sizeBenefit}</td>
        </tr>
      </c:forEach>
    </table>
    <p></p>
    <form name="change" action="epam.bookticket.web.BaseServletController" method="get">
      <input type="hidden" name="controllerName" value="Change">
      <input name="deleteU" type="button" onclick="deleteUser()" value="Удалить">
      <input name="changeU" type="button" onclick="changeUser()" value="Изменить">
      <p></p>
      <div id="info"></div>
      <div id="info2"></div>
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
