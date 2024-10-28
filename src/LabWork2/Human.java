package LabWork2;

public class Human {
    private String Name;
    private int height;

    public Human() {
        this.Name = "Неизвестное имя";
        this.height = 0;
    }

    public Human(String Name, int height) {
        this.Name = Name;
        this.height = height;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return (this.Name + ", рост: " + this.height);
    }

    public void printInformation() {
        this.printInformation("\n");
    }

    public void printInformation(String end) {
        System.out.print("Человек с именем \"" + Name + "\" и ростом " + height + end);
    }
}