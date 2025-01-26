package LabWork5Max;

public class Fans {
    public static void meowsCare(Mewable... mewables) {
        for (Mewable mewable : mewables) {
            mewable.meow();
        }
    }
}
