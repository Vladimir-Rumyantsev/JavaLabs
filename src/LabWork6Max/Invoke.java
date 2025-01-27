package LabWork6Max;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Аннотация может быть применена только к методам
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время исполнения программы
public @interface Invoke {
    // Аннотация не имеет свойств
}
