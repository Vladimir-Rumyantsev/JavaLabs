package LabWork2;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nЗадание 1.2:");

        Human human1 = new Human("Клеопатра", 152);
        Human human2 = new Human("Пушкин", 167);
        Human human3 = new Human("Владимир", 189);

        human1.printInformation();
        human2.printInformation();
        human3.printInformation();

        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name name3 = new Name("Маяковский", "Владимир");

        System.out.println("\nЗадание 1.3:\n" + name1 + "\n" + name2 + "\n" + name3);

        human1.setName(name1.toString());
        human2.setName(name2.toString());
        human3.setName(name3.toString());

        System.out.println("\nЗадание 2.2:");
        human1.printInformation();
        human2.printInformation();
        human3.printInformation();

        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        Path[] arr = new Path[3];
        Path pathAB = new Path(B, 5);
        Path pathAD = new Path(D, 6);
        Path pathAF = new Path(F, 1);
        Path pathBA = new Path(A, 5);
        Path pathBC = new Path(C, 3);
//        Path pathAB = new Path(B, 5);
//        Path pathAB = new Path(B, 5);
//        Path pathAB = new Path(B, 5);
//        Path pathAB = new Path(B, 5);

//        A.addPath(B, 5);
//        A.addPath(D, 6);
//        A.addPath(F, 1);
//
//        B.addPath(A, 5);
//        B.addPath(C, 3);
//
//        C.addPath(B, 3);
//        C.addPath(D, 4);
//
//        D.addPath(A, 6);
//        D.addPath(C, 4);
//        D.addPath(E, 2);
//
//        E.addPath(F, 2);
//
//        F.addPath(B, 1);
//        F.addPath(E, 2);

        System.out.println("\nЗадание 3.3:");
        human1.printInformation();
        human2.printInformation();
        human3.printInformation();
    }
}
