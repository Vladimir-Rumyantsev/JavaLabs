package LabWork4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Task_3_4 {
    public static void main(String[] args) {

        // Задание 3.4
        System.out.println("\n\nЗадание 3.4:");

        // Пример 1: Разделение чисел на положительные и отрицательные
        List<Integer> numberList = List.of(1, -3, 7);
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
        List<String> stringList = List.of("qwerty", "asdfg", "zx", "qw");
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

    public static <T, P> P collect(List<T> inputList, Supplier<P> collectionSupplier, BiConsumer<P, T> accumulator) {
        P collection = collectionSupplier.get();
        for (T item : inputList) {
            accumulator.accept(collection, item);
        }
        return collection;
    }
}
