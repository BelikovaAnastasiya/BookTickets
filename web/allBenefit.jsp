<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="styles/normalize.css">
  <link rel="stylesheet" href="styles/stylesAdd.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
  <script src="js/jquery-3.2.1.js"></script>
  <title>Скидочная система</title>
  <script>
    var pokazatel_prosmotra = 0;

    function deleteForm()
    {
      if (pokazatel_prosmotra == 0) {
        var el = '<html> <form name="delete" action="classes.web.DeleteBenefit" method="get" >Введите название скидки: <input name="procent" type="text" required ><input type="submit" name="del" value="Удалить"></form></html>';
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
    <img id="logo" src="images/logo2.png" alt="Logo">
    <form name="sign" action="index.jsp" method="get">
      <%request.setCharacterEncoding("UTF-8");%>
      <h2>Вы зашли под записью: <%= session.getAttribute("adminname")%></h2>
      <button name="button_sign">Выйти</button>
    </form>
  </header>
  <aside>
    <nav>
      <ul class="top-menu">
        <li><a href="classes.web.AdminAddUser">Добавить клиента</a></li>
        <li><a href="classes.web.SeeAllUsers">Управление клиентами</a></li>
        <li><a href="addMovie.jsp">Добавить фильм</a></li>
        <li><a href="//">Изменить данные о фильмах</a></li>
        <li><a href="classes.web.BenefitSystem">Скидочная система</a></li>
        <li><a href="//">?Управление заказами?</a></li>
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
    <form name="actionBenefit" action="classes.web.AddBenefit">
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
