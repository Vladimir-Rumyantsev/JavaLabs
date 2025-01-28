package LabWork6;

import java.lang.annotation.Annotation;

@Validate(value = {String.class, Integer.class})
public class Task_2_4 {

    public static void main(String[] args) {
        // Пример использования аннотированного класса
        Task_2_4 example = new Task_2_4();
        System.out.println("Класс Task_2_4 аннотирован @Validate с значениями String.class и Integer.class");

        // Проверка, что аннотация @Validate содержит ожидаемые классы
        checkValidateAnnotation();
    }

    private static void checkValidateAnnotation() {
        Validate validateAnnotation = Task_2_4.class.getAnnotation(Validate.class);
        if (validateAnnotation != null) {
            Class<?>[] classes = validateAnnotation.value();
            for (Class<?> clazz : classes) {
                System.out.println("Класс в аннотации @Validate: " + clazz.getName());
            }
        }
    }
}
