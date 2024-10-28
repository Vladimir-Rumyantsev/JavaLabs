package LabLesson151024;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();

        car1.setBrand("ВАЗ");
        car1.setModel("2101");
        car1.setNumber("А123БВ");

        System.out.println("Марка: " + car1.getBrand());
        System.out.println("Модель: " + car1.getModel());
        System.out.println("Номер: " + car1.getNumber());

        car1.start();
        car1.stop();

        Car car2 = new Car("Mercedes", "600", "Б456ГД");

        System.out.println("\nМарка: " + car2.getBrand());
        System.out.println("Модель: " + car2.getModel());
        System.out.println("Номер: " + car2.getNumber());

        car2.start();
        car2.stop();
    }
}
