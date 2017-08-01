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
    <script src="../../js/jquery-3.2.1.js"></script>
    <title>Страница регистрации</title>
    <script>
        function validate_form(form) {
            var p1 = form.password.value;
            var p2 = form.password_2.value;

            if(p1 != p2) {
                form.password.setCustomValidity("Пароли не совпадают.");
                return false;
            }
            else
            {
                form.password.setCustomValidity("");
            }
            return true;
        }

        var pokazatel_prosmotra = 0;

        function del_mail()
        {
            $('#info').remove();
            pokazatel_prosmotra = 0;
        }
    </script>
</head>
<body>

<div id="wrapper">
    <header>
        <img id="logo" src="../../images/logo2.png" alt="Logo">
    </header>
    <section>
        <form name="sign" action="epam.bookticket.web.BaseServletController" method="get" id="" >
            <input type="hidden" name="controllerName" value="AddUser">
            <div class="block">
                <p>Ваш логин: <input type="text" name="login" required></p>
                <p>Ваш пароль: <input name="password" type="password" id="password" placeholder=">6 символов (буквы, цифры)" pattern ="(?=^.{6,}$)(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).*$" required></p>
                <p>Повторите пароль: <input name="password_2" type="password" id="password2" required></p>
                <p>Ваш e-mail: <input name="mail" type="email" pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$" required></p>
                <p>Введите имя: <input type="text" name="name"></p>
                <p>Введите фамилию: <input type="text" name="surname"></p>
                <p>Номер кредитной карты: <input type="text" name="card"></p>
                <p>Номер телефона: <input type="text" name="phone"  placeholder="(XX) XXX-XX-XX" pattern="\([0-9]{2}\)\s[0-9]{3}-[0-9]{2}-[0-9]{2}"></p>
            </div>
            <div class="buttons">
                <input type="submit" name="save" onclick="validate_form(this.form)" value="Сохранить">
                <input type="reset" onclick="onreset(this.form)" value="Очистить">
            </div>
        </form>
        <form action="epam.bookticket.web.BaseServletController">
            <input type="hidden" name="controllerName" value="AddUser">
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