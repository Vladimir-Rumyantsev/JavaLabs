package LabWork4Max;

/*
Задание 1. Обобщенные типы. Типовые переменные, <>.
Задание 2. Параметризации. Маски типов и их ограничения.
Задание 3. Обобщенные методы. Автовывод типа
*/

//import java.util.*;
//import java.util.stream.Collectors;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.*;

public class Main {
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


        // Задание 2.3.

        // Пример использования
        Box<CordPoint> cordPointBox = new Box<>();
        Box<Object> objectBox = new Box<>();

        placeCordPointInBox(cordPointBox);
        placeCordPointInBox(objectBox);

        // Выведем содержимое коробок для проверки
        System.out.println(cordPointBox.getItem());
        System.out.println(objectBox.getItem());


        // Задания 3:

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



        // Задание 3.2
        System.out.println("\n\nЗадание 3.2:");

        // Пример 1: Фильтрация строк с менее чем тремя символами
        stringList = List.of("qwerty", "asdfg", "zx");
        Predicate<String> lengthPredicate = s -> s.length() >= 3;
        List<String> filteredStrings = filterList(stringList, lengthPredicate);
        System.out.println("\nПример 1:\nВход: " + stringList + "\nВыход: " + filteredStrings); // [qwerty, asdfg]

        // Пример 2: Фильтрация положительных чисел
        numberList = List.of(1, -3, 7);
        Predicate<Integer> positivePredicate = n -> n < 0;
        List<Integer> filteredNumbers = filterList(numberList, positivePredicate);
        System.out.println("\nПример 2:\nВход: " + numberList + "\nВыход: " + filteredNumbers); // [-3]

        // Пример 3: Фильтрация массивов, в которых нет положительных элементов
        arrayList = List.of(new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{0, -1, 2});
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



        // Задание 3.3
        System.out.println("\n\nЗадание 3.3:");

        // Пример 1: Сведение списка строк в одну большую строку
        stringList = List.of("qwerty", "asdfg", "zx");
        BinaryOperator<String> stringAccumulator = (a, b) -> a + b;
        String concatenatedString = reduceList(stringList, stringAccumulator, "");
        System.out.println("\nПример 1:\nВход: " + stringList + "\nВыход: " + concatenatedString); // qwertyasdfgzx

        // Пример 2: Сведение списка чисел в их сумму
        numberList = List.of(1, -3, 7);
        int sum = reduceList(numberList, Integer::sum, 0);
        System.out.println("\nПример 2:\nВход: " + numberList + "\nВыход: " + sum); // 5

        // Пример 3: Сведение списка списков чисел в общее количество элементов
        List<List<Integer>> listOfLists = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8, 9));;
        sum = reduceList(applyFunctionToList(listOfLists, List::size), Integer::sum, 0);
        System.out.println("\nПример 3:\nВход: " + listOfLists + "\nВыход: " + sum); // 9



        // Задание 3.4
        System.out.println("\n\nЗадание 3.4:");

        // Пример 1: Разделение чисел на положительные и отрицательные
        numberList = List.of(1, -3, 7);
        Supplier<List<List<Integer>>> listSupplier = () -> List.of(new ArrayList<>(), new ArrayList<>());
        BiConsumer<List<List<Integer>>, Integer> listAccumulator = (lists, number) -> {
            if (number >= 0) {
                lists.get(0).add(number);
            } else {
                lists.get(1).add(number);
            }
        };
        List<List<Integer>> partitionedNumbers = collect(numberList, listSupplier, listAccumulator);
        System.out.println("\nПример 1:\nВход: " + numberList + "\nВыход: " + partitionedNumbers); // [[1, 7], [-3]]

        // Пример 2: Разделение строк по длине
        stringList = List.of("qwerty", "asdfg", "zx", "qw");
        Supplier<List<List<String>>> stringListSupplier = ArrayList::new;
        BiConsumer<List<List<String>>, String> stringListAccumulator = (lists, str) -> {
            boolean added = false;
            for (List<String> sublist : lists) {
                if (sublist.isEmpty() || sublist.get(0).length() == str.length()) {
                    sublist.add(str);
                    added = true;
                    break;
                }
            }
            if (!added) {
                List<String> newSublist = new ArrayList<>();
                newSublist.add(str);
                lists.add(newSublist);
            }
        };
        List<List<String>> partitionedStrings = collect(stringList, stringListSupplier, stringListAccumulator);
        System.out.println("\nПример 1:\nВход: " + stringList + "\nВыход: " + partitionedStrings);
        // [[qwerty, asdfg], [zx], [qw]]

        // Пример 3: Создание набора уникальных строк
        List<String> uniqueStringList = List.of("qwerty", "asdfg", "qwerty", "qw");
        Supplier<List<String>> setSupplier = ArrayList::new;
        BiConsumer<List<String>, String> setAccumulator = (lists, str) -> {
            boolean added = true;
            for (String sublist : lists) {
                if (Objects.equals(sublist, str)) {
                    added = false;
                    break;
                }
            }
            if (added) {
                lists.add(str);
            }
        };
        List<String> uniqueStrings = collect(uniqueStringList, setSupplier, setAccumulator);
        System.out.println("\nПример 1:\nВход: " + uniqueStringList + "\nВыход: " + uniqueStrings);
        // [qwerty, asdfg, qw]
    }

    public static <T> void printValue(Storage<T> storage, T defaultValue) {
        T value = storage.getValueOrDefault(defaultValue);
        System.out.println(value);
    }

    public static <T> void placeCordPointInBox(Box<T> box) {
        // Создаем CordPoint с произвольными значениями
        CordPoint point = new CordPoint(1.0f, 2.0f, 3.0f);
        // Кладем CordPoint в Box
        box.setItem((T) point);
    }

    public static <T, P> List<P> applyFunctionToList(List<T> inputList, Function<T, P> function) {
        List<P> resultList = new ArrayList<>();
        for (T item : inputList) {
            resultList.add(function.apply(item));
        }
        return resultList;
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

    public static <T, P> P collect(List<T> inputList, Supplier<P> collectionSupplier, BiConsumer<P, T> accumulator) {
        P collection = collectionSupplier.get();
        for (T item : inputList) {
            accumulator.accept(collection, item);
        }
        return collection;
    }
}
