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