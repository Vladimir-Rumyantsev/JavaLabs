package LabWork6;

import java.lang.reflect.Field;

@ToString
public class Task_2_3 {

    @ToString(value = ToString.Value.NO)
    private int exampleField;

    public static void main(String[] args) {
        // Пример использования аннотированного класса
        Task_2_3 example = new Task_2_3();
        System.out.println("Класс Task_2_3 аннотирован @ToString с значением YES");

        // Получение значения аннотации @ToString с использованием рефлексии
        try {
            Field field = Task_2_3.class.getDeclaredField("exampleField");
            ToString toStringAnnotation = field.getAnnotation(ToString.class);
            if (toStringAnnotation != null) {
                System.out.println("Значение аннотации @ToString для поля exampleField: " + toStringAnnotation.value());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
