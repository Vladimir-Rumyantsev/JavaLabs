package LabWork5;

public class Task_2_1 {
    public static void main(String[] args) {
        System.out.println("\nЗадание 2.1:\n");
        Cat cat = new Cat("Васька");
        cat.meow();
        System.out.println();
        Fans.meowsCare(cat, cat, cat, cat, cat); // Вызываем метод 5 раз
        System.out.println("\nКот мяукал " + cat.getMeowCount() + " раз");
    }
}
