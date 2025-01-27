package LabWork4;

public class Task_1_1 {
    public static void main(String[] args) {

        // Создаем коробку для хранения целочисленного значения
        Box<Integer> integerBox = new Box<>();

        // Размещаем число 3 в коробку
        integerBox.put(3);

        // Передаем коробку в метод и выводим значение на экран
        System.out.println("\nЗадание 1.1:\n" + stringBoxContent(integerBox));
    }

    // Метод для извлечения значения из коробки
    public static String stringBoxContent(Box<Integer> box) {
        if (!box.isEmpty()) {
            Integer value = box.take();
            return "Value in the box: " + value;
        } else {
            return "The box is empty";
        }
    }
}
