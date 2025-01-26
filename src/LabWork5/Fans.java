package LabWork5;

public class Fans {
    public static void meowsCare(Mewable... mewables) {
        for (Mewable mewable : mewables) {
            mewable.meow();
        }
    }
}
