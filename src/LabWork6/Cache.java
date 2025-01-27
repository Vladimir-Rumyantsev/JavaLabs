package LabWork6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Аннотация может быть применена только к типам (классам)
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время исполнения программы
public @interface Cache {
    String[] value() default {}; // Необязательное свойство value типа String[] с значением по умолчанию пустой массив
}
