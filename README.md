\# UI тесты для Stellar Burgers



\## Описание проекта

Проект содержит автотесты для веб-приложения Stellar Burgers. Тесты проверяют регистрацию, вход и работу конструктора бургеров.



\## Технологии

\- Java 11

\- JUnit 4.13.2

\- Selenium 4.11.0

\- WebDriverManager 5.6.2

\- REST Assured 5.3.0

\- Allure 2.21.0

\- Maven 3.9.11



\## Запуск тестов



\### Chrome (по умолчанию)

mvn clean test



\### Яндекс Браузер

mvn clean test -Dbrowser=yandex



\## Генерация Allure отчёта

mvn allure:report



Отчёт будет доступен в `target/allure-report/index.html`

