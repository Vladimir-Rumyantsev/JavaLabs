package LabWork6;

@Two(first = "Example", second = 42)
public class Task_2_5 {

    public static void main(String[] args) {
        // Пример использования аннотированного класса
        Task_2_5 example = new Task_2_5();
        System.out.println("Класс Task_2_5 аннотирован @Two с значениями first = \"Example\" и second = 42");

        // Вывод значений свойств аннотации @Two
        printTwoAnnotationValues();
    }

    private static void printTwoAnnotationValues() {
        Two twoAnnotation = Task_2_5.class.getAnnotation(Two.class);
        if (twoAnnotation != null) {
            System.out.println("Значение first в аннотации @Two: " + twoAnnotation.first());
            System.out.println("Значение second в аннотации @Two: " + twoAnnotation.second());
        }
    }
}
