package LabWork6Max;

@Default(value = String.class)
public class Task_2_2 {

    @Default(value = Integer.class)
    private int exampleField;

    public static void main(String[] args) {
        // Пример использования аннотированного класса
        Task_2_2 example = new Task_2_2();
        System.out.println("Класс ExampleClass аннотирован @Default с значением String.class");
    }
}
