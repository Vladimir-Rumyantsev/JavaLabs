//import java.util.List;
//import java.util.function.BinaryOperator;
//
//public class Task3 {
//    public static <T> T reduce(List<T> list, T identity, BinaryOperator<T> accumulator) {
//        return list.stream().reduce(identity, accumulator);
//    }
//
//    public static void main(String[] args) {
//        // Пример 1
//        List<String> strings = List.of("qwerty", "asdfg", "zx");
//        String concatenatedString = reduce(strings, "", (a, b) -> a + b);
//        System.out.println(concatenatedString); // qwertyasdfgzx
//
//        // Пример 2
//        List<Integer> numbers = List.of(1, -3, 7);
//        int sum = reduce(numbers, 0, Integer::sum);
//        System.out.println(sum); // 5
//
//        List<List<Integer>> lists = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
//
//        // Используем метод из задания 1 для преобразования списка списков в список размеров
//        List<Integer> sizes = Task1.apply(lists, List::size);
//
//        // Используем метод из задания 3 для суммирования размеров
//        int totalElements = reduce(sizes, 0, Integer::sum);
//        System.out.println(totalElements); // 9
//    }
//}


package LabWork4Max;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Task_3_1 {
    public static void main(String[] args) {

        // Задание 3.1
        System.out.println("\n\nЗадание 3.1:");

        // Пример 1: Преобразование строк в их длины
        List<String> stringList = List.of("qwerty", "asdfg", "zx");
        List<Integer> lengths = applyFunctionToList(stringList, String::length);
        System.out.println("\nПример 1:\nВход: " + stringList + "\nВыход: " + lengths); // [6, 5, 2]

        // Пример 2: Преобразование отрицательных чисел в положительные
        List<Integer> numberList = List.of(1, -3, 7);
        List<Integer> positiveNumbers = applyFunctionToList(numberList, n -> n < 0 ? -n : n);
        System.out.println("\nПример 2:\nВход: " + numberList + "\nВыход: " + positiveNumbers); // [1, 3, 7]

        // Пример 3: Получение максимальных значений из массивов целых чисел
        List<int[]> arrayList = List.of(new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9});
        List<Integer> maxValues = applyFunctionToList(arrayList, array -> {
            int max = array[0];
            for (int num : array) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        });
        System.out.println("\nПример 3:\nВход: " + arrayList + "\nВыход: " + maxValues); // [3, 6, 9]
    }

    public static <T, P> List<P> applyFunctionToList(List<T> inputList, Function<T, P> function) {
        List<P> resultList = new ArrayList<>();
        for (T item : inputList) {
            resultList.add(function.apply(item));
        }
        return resultList;
    }
}