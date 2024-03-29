# Проект по автоматизации тестирования UI для сайта компании [Авто ру](https://auto.ru/)

## :pushpin: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео пример запуска тестов](#-видео-пример-запуска-тестов)
## :computer: Используемый стек

<p align="center">
<a href="https://www.jetbrains.com/">
<img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg">
</a>
<a href="https://www.java.com/">
<img width="6%" title="Java" src="media/logo/Java.svg">
</a>
<a href="https://ru.selenide.org/">
<img width="6%" title="Selenide" src="media/logo/Selenide.svg">
</a>
<a href="https://aerokube.com/selenoid/latest/">
<img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
</a>
<a href="https://docs.qameta.io/allure/">
<img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg">
</a>
<a href="https://qameta.io/">
<img width="5%" title="Allure TestOps" src="media/logo/AllureTestOps.svg">
</a>
<a href="https://gradle.org/">
<img width="6%" title="Gradle" src="media/logo/Gradle.svg">
</a>
<a href="https://junit.org/junit5/">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
</a>
<a href="https://github.com/">
<img width="6%" title="GitHub" src="media/logo/GitHub.svg">
</a>
<a href="https://www.jenkins.io/">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
</a>
<a href="https://web.telegram.org/">
<img width="6%" title="Telegram" src="media/logo/Telegram.svg">
</a>
<a href="https://www.atlassian.com/ru/software/jira">
<img width="5%" title="Jira" src="media/logo/Jira.svg">
</a>
</p>

- Тесты в данном проекте написаны на языке <code>Java</code> с использованием библиотеки для тестирования [Selenide](https://selenide.org/)
- В качестве сборщика был использован - <code>Gradle</code>
- <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/)
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

## :spiral_notepad: Список тестов
:white_check_mark: Автоматическое заполнение формы объявления по VIN (Параметризованный тест) <br />
:white_check_mark: Проверка отображения страницы авторизации <br />
:white_check_mark: Поиск автомобиля по бренду и модели (Параметризованный тест) <br />
:white_check_mark: Проверка отображения видов транспорта на главной странице (Параметризованный тест) <br />
:white_check_mark: Проверка отчета по VIN (Параметризованный тест) <br />
:white_check_mark: Ручное заполнение формы объявления (Параметризованный тест) <br />
:white_check_mark: Тест поиска моделей по бренду (Параметризованный тест) <br />

## :arrow_forward: Запуск автотестов
### Варианты запуска тестов
- ```test``` -Запуск всех тестов
- ```sanity``` -Запуск тестов sanity

### Запуск тестов из терминала
```
gradle clean test
```


При выполнении команды тесты запустятся локально.

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> [Сборка в Jenkins](https://jenkins.autotests.cloud/job/Students/job/C19-Aleksey_Astashkin-unit15/build?delay=0sec)


### Параметры сборки
* <code>BROWSER</code> – браузер <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера<code>chrome:100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера. По-умолчанию - <code>1920x1080</code>.
* <code>BASE_URL</code> – url, по которому будет открываться тестируемое приложение. По-умолчанию - <code>https://auto.ru/</code>.
* <code>REMOTE_URL</code> – адрес для удаленного запуска тестов.
* <code>REMOTE_LOGIN</code> – логин для удаленного запуска тестов.
* <code>REMOTE_PASSWORD</code> – пароль для удаленного запуска тестов.

<p align="center">
<img title="Jenkins Build" src="media/screens/jenkins build.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> [Пример Allure-отчета](https://jenkins.autotests.cloud/job/Students/job/C19-Aleksey_Astashkin-unit15/64/allure/)
<p align="center">
<img title="Allure Overview" src="media/screens/Allure Overview.png">
</p>

### Результат выполнения теста
Содержание:
* Шаги теста
* Скриншот страницы на последнем шаге
* Page Source
* Логи браузерной консоли
* Видео прогона автотестов

<p align="center">
<img title="Test Results in Alure" src="media/screens/AllureSuites.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> [Интеграция с Allure TestOps](https://allure.autotests.cloud/project/3332/launches)
На вкладке Dashboards отображается:
- Количество тест-кейсов и их статус
- Соотношение ручных/автоматизированных тестов
- Результаты запусков/прохождения тестов в графике по датам
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/DashboardsAllureTestOps.png">
</p>

На вкладке Launches можно увидеть:
- Результаты запусков автоматизированных тестов из Jenkins
- Результаты запусков автоматизированных тестов из Allure TestOps
- Результаты прохождения ручных тест-кейсов
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/LaunchesTestOps.png">
</p>

Результаты выполнения отдельных тестов:
* Шаги теста
* Скриншот страницы на последнем шаге
* Page Source
* Логи браузерной консоли
* Видео прогона автотестов

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/AllureTestCases.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> [Интеграция с Jira](https://jira.autotests.cloud/browse/HOMEWORK-742)
Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>. В задаче отображаются прикреплённые к ней тест-кейсы, а также результаты запусков/прохождения тестов.
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/Jira.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram
После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.
<p align="center">
<img title="Telegram" src="media/screens/Telegram.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео пример запуска теста  "Ручное заполнение формы объявления"
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>
