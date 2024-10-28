package LabWork2;

public class Car {
    private String brand;  // Марка машины
    private String model;  // Модель машины
    private String number; // Номер машины

    public Car() {
        this.brand = "Неизвестная марка";
        this.model = "Неизвестная модель";
        this.number = "Неизвестный номер";
    }

    public Car(String brand, String model, String number) {
        this.brand = brand;
        this.model = model;
        this.number = number;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public void start() {
        System.out.println("Машина " + brand + " " + model + " с номером " + number + " завелась.");
    }

    public void stop() {
        System.out.println("Машина " + brand + " " + model + " с номером " + number + " остановилась.");
    }
}
