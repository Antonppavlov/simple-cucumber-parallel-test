# Пример распараллеливания тестов "Cucumer" с использованием "ru.alfalab.cucumber-parallel-test"
<br>

## Предварительные настройки
**1. Проверить,что установлена Java 8**

**2. Необходимо установить следующие плагины для Intellij IDEA:**

* Cucumber for Java
* Gherkin
* Lombok

**3. Настроить плагин Lombok:**

* в разделе *Build, Execution, Deployment -> Compiler -> Annotation Processors* требуется поставить галочку *Enable annotation processing*
* в разделе *Other settings -> Lombok plugin* требуется поставить галочку *Enable lombok plugin for this project*


Запуск тестов
--------------------

#### Структура проекта

* Важно!!! Плагин, используемый для запуска тестов завязан на путь до feature-файлов  src/test/resources/features. Не рекомендуется его изменять.

* В build.gradle  указывается пакет, где должны лежать классы с новыми пользовательскими шагами:
```
   generateRunner.glue = ["ru.pavlovap.cucumber.steps", "steps"]
```

* В build.gradle указывается тег. Помеченные им .feature будут запущенны
```
    jvmArgs += "-Dcucumber.options=--tags @all"
```


* файл **settings.gradle** содержит только название проекта
* пакет **src/main/java** содержит ваши page object-ы, реализацию шагов, сущности для интеграционных тестов и другие дополнительные классы.
* пакет **src/main/java/restBodies** используется для хранения файлов с телом запросов. На данную папку жестко привязан  шаг отправки запроса.
* директория  **src/test** предназначена только для хранения feature-файлов с тестами.


#### Запуск тестов
Параллельный запуск всех feature-файлов (для каждого feature-файла создается свой runner)

 ```
   > gradlew clean 
   > gradlew generateRunner 
   > gradlew test 
  ```

