//import java.util.*;
//import java.util.function.Function;
//import java.util.function.BiConsumer;
//
//public class CollectionUtil {
//
//    public static <T, P extends Collection<T>> P createCollection(
//            List<T> sourceList,
//            Function<List<T>, P> collectionCreator,
//            BiConsumer<P, T> valueAdder) {
//
//        P resultCollection = collectionCreator.apply(sourceList);
//        for (T value : sourceList) {
//            valueAdder.accept(resultCollection, value);
//        }
//        return resultCollection;
//    }
//
//    public static void main(String[] args) {
//        // Пример 1: Разделение чисел на положительные и отрицательные
//        List<Integer> numbers = Arrays.asList(1, -3, 7, 0, -2, 5);
//        List<List<Integer>> result1 = createCollection(
//                numbers,
//                // Создаем список из двух списков
//                sourceList -> new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()),
//                (result, value) -> {
//                    if (value >= 0) {
//                        result.get(0).add(value);
//                    } else {
//                        result.get(1).add(value);
//                    }
//                }
//        );
//
//        System.out.println("Положительные и нули: " + result1.get(0));
//        System.out.println("Отрицательные числа: " + result1.get(1));
//
//
//        // Пример 2: Разделение строк по длине
//        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw", "abc");
//        Map<Integer, List<String>> result2 = createCollection(
//                strings,
//                sourceList -> new HashMap<>(),
//                (result, value) -> {
//                    result.computeIfAbsent(value.length(), k -> new ArrayList<>()).add(value);
//                }
//        );
//        System.out.println("Строки по длине: " + result2);
//
//        // Пример 3: Удаление дубликатов
//        List<String> stringsWithDuplicates = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
//        Set<String> result3 = createCollection(
//                stringsWithDuplicates,
//                sourceList -> new HashSet<>(),
//                (result, value) -> result.add(value)
//        );
//        System.out.println("Уникальные строки: " + result3);
//    }
//}


package LabWork4Max;

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