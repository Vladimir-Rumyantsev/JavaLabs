package LabWork6Max;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD}) // Аннотация может быть применена к типам и полям
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время исполнения программы
public @interface Default {
    Class<?> value(); // Обязательное свойство value типа Class
}
