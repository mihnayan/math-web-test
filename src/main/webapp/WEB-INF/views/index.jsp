<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Math service</title>
    <link rel="stylesheet" href="static/css/math.css">
    <link rel="stylesheet" href="static/vendor/jquery.modal.min.css">
</head>
<body>
    <header id="header">
        <h1><a href="math.html">Математический сервис</a></h1>
    </header>
    <section id="sect-division" class="section">
        <header id="sect-division__header">
            <h2>Деление чисел</h2>
        </header>
            <div>
                    <form method="POST" action="#">
                        <label>
                            Первое число
                            <input type="text" id="num-1" placeholder="0.0" required>
                        </label>
                        <label>
                            Второе число
                            <input type="text" id="num-2" placeholder="0.0" required>
                        </label>
                        <button type="button" onclick="doOperation()">Получить результат</button>
                    </form>
                </div>
    </section>
    <footer id="footer">
        <address id="company-address">
            <span id="company-name">
                <strong>ООО "Математический сервис"</strong>
            </span>
            <span id="company-info">Компания предоставляет возможности 
                по выполнению математический расчётов с 
                использованием веб-сервисов.
            </span>
        </address>
        <p id="copyright">&copy; 2018 <a href="https://github.com/mihnayan" target="blank">Михаил Мангушев</a></p>
    </footer>
    
    <div id="loader" class="modal">
        <img id="loading-image" src="static/img/loader.gif" alt="loading..">
        <p>Идёт вычисление...</p>
    </div>

    <div id="calc-result-dialog" class="modal">
        <p id="status-text"></p>
        <p id="result-text"></p>
        <a href="#" rel="modal:close">Закрыть</a>
    </div>

    <script type="text/javascript" src="static/vendor/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="static/vendor/jquery.modal.min.js"></script>
    <script type="text/javascript" src="static/js/app.js"></script>
</body>
</html>