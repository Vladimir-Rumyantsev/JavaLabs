package LabWork6;

@ToString
public class Task_2_3 {

    @ToString(value = ToString.Value.NO)
    private int exampleField;

    public static void main(String[] args) {
        // Пример использования аннотированного класса
        Task_2_3 example = new Task_2_3();
        System.out.println("Класс ExampleClass аннотирован @ToString с значением YES");
    }
}
