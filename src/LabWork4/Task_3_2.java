package LabWork4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Task_3_2 {
    public static void main(String[] args) {


        // Задание 3.2
        System.out.println("\n\nЗадание 3.2:");

        // Пример 1: Фильтрация строк с менее чем тремя символами
        List<String> stringList = List.of("qwerty", "asdfg", "zx");
        Predicate<String> lengthPredicate = s -> s.length() >= 3;
        List<String> filteredStrings = filterList(stringList, lengthPredicate);
        System.out.println("\nПример 1:\nВход: " + stringList + "\nВыход: " + filteredStrings); // [qwerty, asdfg]

        // Пример 2: Фильтрация положительных чисел
        List<Integer> numberList = List.of(1, -3, 7);
        Predicate<Integer> positivePredicate = n -> n < 0;
        List<Integer> filteredNumbers = filterList(numberList, positivePredicate);
        System.out.println("\nПример 2:\nВход: " + numberList + "\nВыход: " + filteredNumbers); // [-3]

        // Пример 3: Фильтрация массивов, в которых нет положительных элементов
        List<int[]> arrayList = List.of(new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{0, -1, 2});
        Predicate<int[]> noPositivePredicate = array -> {
            for (int num : array) {
                if (num > 0) {
                    return false;
                }
            }
            return true;
        };
        List<int[]> filteredArrays = filterList(arrayList, noPositivePredicate);
        System.out.println("\nПример 3:\nВход: " + arrayList + "\nВыход: " + filteredArrays); // [[-1, -2, -3]]
    }

    public static <T> List<T> filterList(List<T> inputList, Predicate<T> predicate) {
        List<T> resultList = new ArrayList<>();
        for (T item : inputList) {
            if (predicate.test(item)) {
                resultList.add(item);
            }
        }
        return resultList;
    }
}
