
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="styles/normalize.css">
  <link rel="stylesheet" href="styles/styles.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Kurale&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
  <title>Book Tickets</title>
</head>
<body>
<div id="wrapper">
  <header>
    <img id="logo" src="images/logo2.png" alt="Logo">
    <form name="sign" action="login.jsp" method="get">
      <button name="button_sign">Войти</button>
    </form>
    <form name="FindFilm" action="classes.web.BaseServletController" method="get">
      <input type="hidden" name="controllerName" value="FindFilm">
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
    <img id="kino" src="images/kino.jpg" alt="Kino">
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
