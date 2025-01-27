package LabWork6Max;

public class Task_2_1 {

    @Invoke
    public void annotatedMethod() {
        System.out.println("Этот метод аннотирован @Invoke");
    }

    public static void main(String[] args) {
        Task_2_1 example = new Task_2_1();
        example.annotatedMethod();
    }
}
