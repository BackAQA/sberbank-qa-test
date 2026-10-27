# QA Automation Test

Тестовое задание: автоматизация UI и API тестов.

## 🛠 Стек технологий
- Java 21
- Maven
- Selenide (UI)
- Rest Assured (API)
- JUnit 5
- Allure Report

## 🚀 Как запустить тесты
```bash
mvn clean test
```

## 📊 Как посмотреть Allure отчёт
```bash
mvn allure:serve
```
Отчёт откроется в браузере автоматически.

## 📁 Структура проекта
- src/test/java/ui — UI-тесты и Page Objects (Sberbank).
- src/test/java/api — API-тесты (JSONPlaceholder).
- src/test/java/utils — конфигурации.

## ✅ Что реализовано
1. UI-тест: Переход на сайт Сбербанка, авторизация по логину/паролю с неверными данными, проверка появления ошибки.
2. API-тест: GET-запрос на получение поста и POST-запрос на создание поста с проверкой статус-кодов и тела ответа.