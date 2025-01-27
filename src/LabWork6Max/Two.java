package LabWork6Max;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Аннотация может быть применена только к типам (классам)
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время исполнения программы
public @interface Two {
    String first(); // Обязательное свойство first типа String
    int second(); // Обязательное свойство second типа int
}
