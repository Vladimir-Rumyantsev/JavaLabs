package LabWork6;

@Default(value = String.class)
public class Task_2_2 {

    @Default(value = Integer.class)
    private int exampleField;

    public static void main(String[] args) {
        // Пример использования аннотированного класса
        Task_2_2 example = new Task_2_2();
        System.out.println("Класс Task_2_2 аннотирован @Default с значением String.class");
    }

    // Комментарий: Аннотация @Default используется с разными значениями для класса и поля, чтобы продемонстрировать,
    // что аннотация может быть применена как к типам, так и к полям, и может иметь разные значения для каждого из них.
}
