package LabWork4;

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
