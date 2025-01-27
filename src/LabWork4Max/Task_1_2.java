//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class Task1 {
//    public static <T, P> List<P> apply(List<T> list, Function<T, P> function) {
//        return list.stream().map(function).collect(Collectors.toList());
//    }
//}


package LabWork4Max;

public class Task_1_2 {
    public static void main(String[] args) {

        // Задание 1.2.

        // Создаем Хранилище чисел со значением null
        Storage<Integer> intStorageNull = new Storage<>(null);
        printValue(intStorageNull, 0);

        // Создаем Хранилище чисел со значением 99
        Storage<Integer> intStorage99 = new Storage<>(99);
        printValue(intStorage99, -1);

        // Создаем Хранилище строк со значением null
        Storage<String> stringStorageNull = new Storage<>(null);
        printValue(stringStorageNull, "default");

        // Создаем Хранилище строк со значением "hello"
        Storage<String> stringStorageHello = new Storage<>("hello");
        printValue(stringStorageHello, "hello world");
    }

    public static <T> void printValue(Storage<T> storage, T defaultValue) {
        T value = storage.getValueOrDefault(defaultValue);
        System.out.println(value);
    }
}