import java.util.Scanner;

public class test {
    public static void main(String[] args) {

////        Scanner s = new Scanner(System.in);
//
////        System.out.print("\nЗадайте число: ");
//        int ch1 = 0;
//        int ch2 = 0;
//        int ch3 = 0;
//
//        int i = 1;
//        while (i <= 10) {
//            ch1 += i;
//            i++;
//        }
//        System.out.print("\nОтвет 1: " + ch1);
//
//        i = 1;
//        do {
//            ch2 += i;
//            i++;
//        } while (i <= 10);
//        System.out.print("\nОтвет 2: " + ch2);
//
//        for (i = 1; i <= 10; i++) {
//            ch3 += i;
//        }
//        System.out.println("\nОтвет 3: " + ch3);

//        Scanner s = new Scanner(System.in);
//        String str = s.nextInt();

//        test m = new test();
//        m.leftTriangle(12);
        String str = "123";
        str += "456";
        System.out.print(str);

    }

    public void leftTriangle (int x) {
        StringBuilder finalLine = new StringBuilder();
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) {
                finalLine.append("*");
            }
            finalLine.append("\n");
        }
        System.out.println(finalLine);
    }
}
