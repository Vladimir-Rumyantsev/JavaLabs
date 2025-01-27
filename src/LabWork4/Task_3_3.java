package LabWork4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Task_3_3 {
    public static void main(String[] args) {

        // Задание 3.3
        System.out.println("\n\nЗадание 3.3:");

        // Пример 1: Сведение списка строк в одну большую строку
        List<String> stringList = List.of("qwerty", "asdfg", "zx");
        BinaryOperator<String> stringAccumulator = (a, b) -> a + b;
        String concatenatedString = reduceList(stringList, stringAccumulator, "");
        System.out.println("\nПример 1:\nВход: " + stringList + "\nВыход: " + concatenatedString); // qwertyasdfgzx

        // Пример 2: Сведение списка чисел в их сумму
        List<Integer> numberList = List.of(1, -3, 7);
        int sum = reduceList(numberList, Integer::sum, 0);
        System.out.println("\nПример 2:\nВход: " + numberList + "\nВыход: " + sum); // 5

        // Пример 3: Сведение списка списков чисел в общее количество элементов
        List<List<Integer>> listOfLists = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8, 9));
        ;
        sum = reduceList(applyFunctionToList(listOfLists, List::size), Integer::sum, 0);
        System.out.println("\nПример 3:\nВход: " + listOfLists + "\nВыход: " + sum); // 9
    }

    public static <T> T reduceList(List<T> inputList, BinaryOperator<T> accumulator, T identity) {
        if (inputList == null || inputList.isEmpty()) {
            return identity;
        }
        T result = identity;
        for (T item : inputList) {
            result = accumulator.apply(result, item);
        }
        return result;
    }

    public static <T, P> List<P> applyFunctionToList(List<T> inputList, Function<T, P> function) {
        List<P> resultList = new ArrayList<>();
        for (T item : inputList) {
            resultList.add(function.apply(item));
        }
        return resultList;
    }
}
