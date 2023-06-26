package patterns.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 * Билдер, чаще всего в апи тестах отправляютяс модельные классы либо pojo классы для того,чтобы иметировать json. И как
 * раз таки в каждом классе много полей, чаще всего эти поля заполняются через конструктор, либо через сеттеры. Как раз
 * таки паттерн Билдер позволяет создать модель этого класса не указывая обязательные поля (какие-то поля могут быть null),
 * какие-то поля в нужной последовательности заполнить пример для использованиая библиотека lambock. Пример реализации в
 * классе BuilderTest.
 */
public class UserModel {
    private String username;
    private String password;
    private Integer age;
    private Boolean isMarried;
    private Double salary;
}
