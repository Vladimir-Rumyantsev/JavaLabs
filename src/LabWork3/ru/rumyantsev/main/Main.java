package LabWork3.ru.rumyantsev.main;

import java.util.Arrays;
import LabWork3.ru.rumyantsev.math.Fraction;
import LabWork3.ru.rumyantsev.geo.*;

public class Main {
    static Main m = new Main();

    public static void main(String[] args) {

        System.out.println("\n\nЗадание 7.3:\nargs = " + Arrays.toString(args));

        if (args.length >= 2) {
            double result = m.power(args[0], args[1]);
            System.out.println("Результат возведения первого числа args во второе: " + result);
        } else {
            System.out.println("В args меньше двух элементов.");
        }
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
