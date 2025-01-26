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