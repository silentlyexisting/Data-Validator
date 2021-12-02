### Hexlet tests and linter status:
[![Actions Status](https://github.com/silentlyexisting/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/silentlyexisting/java-project-lvl3/actions)
![example workflow](https://github.com/silentlyexisting/java-project-lvl3/actions/workflows/java-ci.yml/badge.svg)
<a href="https://codeclimate.com/github/silentlyexisting/java-project-lvl3/maintainability"><img src="https://api.codeclimate.com/v1/badges/138318ecad69210bf1d9/maintainability" /></a>
<a href="https://codeclimate.com/github/silentlyexisting/java-project-lvl3/test_coverage"><img src="https://api.codeclimate.com/v1/badges/138318ecad69210bf1d9/test_coverage" /></a>

### <b>Валидатор данных | Data Validator</b>

<b>Библиотека, с помощью которой можно проверять корректность любых данных.</b>

    Подобных библиотек множество в каждом языке, так как практически все программы работают с внешними данными, которые нужно проверять на корректность.
    В первую очередь речь идет про данные форм заполняемых пользователями.
    За основу для проекта взята библиотека yup.

    Интерфейс библиотеки для валидации.
    Яркий пример DSL, специализированного языка, позволяющего декларативно (описательно) описывать то, что вы хотите от кода.
    Код, написанный в таком стиле, читается значительно легче, чем работа с прямым созданием объектов.
    Во многом этот подход базируется на паттерне fluent-интерфейс.

<b>Пример использования:</b>
```java
import code.Validator;
import code.schemas.StringSchema;
import code.schemas.NumberSchema;
import code.schemas.MapSchema;
import code.schemas.BaseSchema;

Validator validator = new Validator();

// строки
StringSchema schema = validator.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// числа
NumberSchema schema = validator.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// объект Map с поддержкой проверки структуры
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", validator.string().required());
schemas.put("age", validator.number().positive());

MapSchema schema = validator.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```