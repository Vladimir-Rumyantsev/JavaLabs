//import java.util.List;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//public class Task2 {
//    public static <T> List<T> test(List<T> list, Predicate<T> predicate) {
//        return list.stream().filter(predicate).collect(Collectors.toList());
//    }
//}


package LabWork4Max;

public class Task_2_3 {
    public static void main(String[] args) {

        // Задание 2.3.

        // Пример использования
        Box<CordPoint> cordPointBox = new Box<>();
        Box<Object> objectBox = new Box<>();

        placeCordPointInBox(cordPointBox);
        placeCordPointInBox(objectBox);

        // Выведем содержимое коробок для проверки
        System.out.println(cordPointBox.getItem());
        System.out.println(objectBox.getItem());
    }

    public static <T> void placeCordPointInBox(Box<T> box) {
        // Создаем CordPoint с произвольными значениями
        CordPoint point = new CordPoint(1.0f, 2.0f, 3.0f);
        // Кладем CordPoint в Box
        box.setItem((T) point);
    }
}