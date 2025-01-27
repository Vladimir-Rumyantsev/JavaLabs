package LabWork6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE}) // Аннотация может быть применена к типам и аннотациям
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время исполнения программы
public @interface Validate {
    Class<?>[] value(); // Обязательное свойство value типа Class[]
}
