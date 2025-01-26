package LabWork5Max;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Васька");
        cat.meow();
        System.out.println();
        int meowCount = meowsCare(cat, cat, cat, cat, cat); // Вызываем метод 5 раз
        System.out.println("\nВнутри метода кот мяукал " + meowCount +
                " раз\nВсего кот мяукал " + cat.getMeowCount() + " раз");
    }

    public static int meowsCare(Mewable... mewables) {
        int totalMeows = 0;
        for (Mewable mewable : mewables) {
            mewable.meow();
            totalMeows++;
        }
        return totalMeows;
    }
}
