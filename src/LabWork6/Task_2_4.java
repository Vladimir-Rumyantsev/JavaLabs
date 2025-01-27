package LabWork6;

@Validate(value = {String.class, Integer.class})
public class Task_2_4 {

    public static void main(String[] args) {
        // Пример использования аннотированного класса
        Task_2_4 example = new Task_2_4();
        System.out.println("Класс ExampleClass аннотирован @Validate с значениями String.class и Integer.class");
    }
}
