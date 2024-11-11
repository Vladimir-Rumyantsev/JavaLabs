package LabWork3.ru.rumyantsev.main;

import java.util.Arrays;
import LabWork3.ru.rumyantsev.math.Fraction;
import LabWork3.ru.rumyantsev.geo.*;

public class Main {
    static Main m = new Main();

    public static void main(String[] args) {

        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(3, 6);
        Fraction f3 = new Fraction(3, -5);
        Fraction f4 = new Fraction(3, -9);

        System.out.println(
                "\nЗадание 1.4:\nf1 = 3/5 = " + f1 + "\nf2 = 3/6 = " + f2 +
                "\nf3 = 3/-5 = " + f3 + "\nf4 = 3/-9 = " + f4
        );

        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        A.addPath(B, 5);
        A.addPath(D, 6);
        A.addPath(F, 1);

        B.addPath(A, 5);
        B.addPath(C, 3);

        C.addPath(B, 3);
        C.addPath(D, 4);

        D.addPath(A, 6);
        D.addPath(C, 4);
        D.addPath(E, 2);

        E.addPath(F, 2);

        F.addPath(B, 1);
        F.addPath(B, 2);
        F.addPath(E, 2);
        F.addPath(E, 3);

        City F2 = new City("F2");
        Path[] pathsF2 = new Path[2];
        pathsF2[0] = new Path(B, 1);
        pathsF2[1] = new Path(E, 2);
        F2.setPath(pathsF2);

        Route FDRoute = new Route(F, D);

        Number[] arr1 = new Number[3];
        arr1[0] = 2;
        arr1[1] = f1;
        arr1[2] = 2.3;

        Number[] arr2 = new Number[4];
        arr2[0] = 3.6;
        arr2[1] = new Fraction(49, 12);
        arr2[2] = 3;
        arr2[3] = new Fraction(3, 2);

        Number[] arr3 = new Number[2];
        arr3[0] = new Fraction(1, 3);
        arr3[1] = 1;

        System.out.println(
                "\nЗадание 1.10:\n" + F + "\n\nЗадание 2.5:\n" + FDRoute +
                "\n\nЗадание 5.1:\n2 + (3/5) + 2.3 = " + m.sumNumbers(arr1) +
                "\n3.6 + (49/12) + 3 + (3/2) = " + m.sumNumbers(arr2) +
                "\n(1/3) + 1 = " + m.sumNumbers(arr3) +
                "\n\nЗадание 6.5:\nОбновлённая и устаревшая версия сущности Город эквивалентны при одинаковых данных: "
                + F.equals(F2)
        );

        LabWork3.Fraction f5 = new LabWork3.Fraction(3, 5);
        LabWork3.Fraction f6 = new LabWork3.Fraction(3, 6);
        LabWork3.Fraction f7 = new LabWork3.Fraction(3, -5);
        LabWork3.Fraction f8 = new LabWork3.Fraction(3, -9);

        System.out.println(
                "\nЗадание 7.2:\nf5 = 3/5 = " + f5 + "\nf6 = 3/6 = " + f6 +"\nf7 = 3/-5 = " + f7 +
                "\nf8 = 3/-9 = " + f8 + "\n\nЗадание 7.3:\nargs = " + Arrays.toString(args)
        );

        if (args.length >= 2) {
            double result = m.power(args[0], args[1]);
            System.out.println("Результат возведения первого числа args во второе: " + result);
        } else {
            System.out.println("Нет двух элементов в args для возведения одного во второе.");
        }

        Fraction f9 = f4.clone();
        System.out.println("\nЗадание 8.3:\nf4 = " + f4 + "\nf9 = f4.clone() = " + f9);
    }

    public double sumNumbers(Number[] nums) {
        double sum = 0;
        for (Number num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public double power(String xStr, String yStr) {
        try {
            int x = Integer.parseInt(xStr);
            int y = Integer.parseInt(yStr);
            return Math.pow(x, y);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
