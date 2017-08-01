<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="../../styles/normalizeR.css">
  <link rel="stylesheet" href="../../styles/stylesAdd.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
  <title>Заказ билетов</title>
</head>
<body>
<div id="wrapper">
  <header>
    <img id="logo" src="../../images/logo2.png" alt="Logo">
  </header>
  <section>
    <form name="add" action="epam.bookticket.web.BaseServletController" method="get">
      <input type="hidden" name="controllerName" value="AddReservation">
      <table border="1" id="tb2">
        <tr>
          <td>Название</td>
          <td>Год выпуска</td>
          <td>Жанр</td>
          <td>Актеры</td>
        </tr>
        <c:forEach items="${m}" var="movies">
          <tr>
            <td>${movies.title}</td>
            <td> ${movies.yearOfProduction}</td>
            <td> ${movies.type}</td>
            <td> ${movies.mainActors}</td>
          </tr>
        </c:forEach>
      </table>
      <div class="block">
        <p>Введите название фильма:<input type="text" name="movieTitle" required></p>
        <p>Выберите кинотеатр:
          <select name="param" required>
          <option value="" disabled selected >Варианты</option>
            <option value="Аврора">Аврора</option>
            <option value="Беларусь">Беларусь</option>
            <option value="Берестье">Берестье</option>
            <option value="Мир">Мир</option>
            <option value="Москва">Москва</option>
            <option value="Октябрь">Октябрь</option>
            <option value="Пионер">Пионер</option>
            <option value="Ракета">Ракета</option>
            <option value="Центральный">Центральный</option>
          </select></p>
        <p>Введите кол-во билетов:<input type="number" name="ticket" required min="1" max="10"> </p>
        <p>Предпочитаемые места: <input type="text" name="chain"></p>
        <p>Дата:<input type="date" name="date" required></p>
        <p>Выберите сеанс:
          <select name="time" required>
            <option value="" disabled selected >Варианты</option>
            <option value="1">Вечерний</option>
            <option value="0">Дневной</option>
          </select></p>
      </div>
      <div class="buttons">
        <input type="submit" name="save" value="Сохранить">
        <input type="submit" name="pay" value="Оплатить">
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
