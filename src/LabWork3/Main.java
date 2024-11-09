package LabWork3;

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

        Route AFRoute = new Route(A, F);

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
                "\nЗадание 1.10:\n" + F + "\n\nЗадание 2.5:\n" + AFRoute +
                "\n\nЗадание 5.1:\n2 + (3/5) + 2.3 = " + m.sumNumbers(arr1) +
                "\n3.6 + (49/12) + 3 + (3/2) = " + m.sumNumbers(arr2) +
                "\n(1/3) + 1 = " + m.sumNumbers(arr3)
        );
    }

    public double sumNumbers(Number[] nums) {
        double sum = 0;
        for (Number num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }
}
