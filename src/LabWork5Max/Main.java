package LabWork5Max;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // Задание 2.1

        Cat cat = new Cat("Васька");
        cat.meow();
        System.out.println();
        int meowCount = meowsCare(cat, cat, cat, cat, cat); // Вызываем метод 5 раз
        System.out.println("\nВнутри метода кот мяукал " + meowCount +
                " раз\nВсего кот мяукал " + cat.getMeowCount() + " раз");


        // Задание 3.7

        // Пример списков L1 и L2
        List<Integer> L1 = new ArrayList<>();
        L1.add(1);
        L1.add(2);
        L1.add(3);
        L1.add(4);

        List<Integer> L2 = new ArrayList<>();
        L2.add(3);
        L2.add(4);
        L2.add(5);
        L2.add(6);

        // Найти общие элементы и создать список L
        List<Integer> L = findCommonElements(L1, L2);

        // Вывести список L
        System.out.println("Список L: " + L);


        // Задание 4.7

        GasStationMonitor.main(args);


        // Задание 5.7

        UniqueLettersCounter.main(args);


        // Задание 6.2

        // Пример списка
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Создаем очередь
        Queue<Integer> queue = buildQueueFromList(list);

        // Выводим элементы очереди
        System.out.println("Очередь:");
        for (Integer element : queue) {
            System.out.print(element + " ");
        }


        // Задание 7.1

        List<Point> points = Arrays.asList(
                new Point(1, 2),
                new Point(2, 3),
                new Point(1, 2),
                new Point(3, -4),
                new Point(2, 3),
                new Point(4, 5)
        );

        Polyline polyline = points.stream()
                .distinct() // Убираем дубликаты
                .sorted((p1, p2) -> Double.compare(p1.getX(), p2.getX())) // Сортируем по X
                .map(p -> new Point(p.getX(), Math.abs(p.getY()))) // Делаем отрицательные Y положительными
                .collect(Collectors.collectingAndThen(Collectors.toList(), Polyline::new)); // Собираем в Polyline

        System.out.println(polyline);


        // Задание 7.2

        String filePath = "src/LabWork5Max/file.txt";

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            Map<Integer, List<String>> groupedPeople = lines
                    .map(line -> line.split(":"))
                    .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                    .collect(Collectors.groupingBy(
                            parts -> Integer.parseInt(parts[1]),
                            Collectors.mapping(parts -> capitalizeFirstLetter(parts[0].toLowerCase()), Collectors.toList())
                    ));

            System.out.println(groupedPeople);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int meowsCare(Mewable... mewables) {
        int totalMeows = 0;
        for (Mewable mewable : mewables) {
            mewable.meow();
            totalMeows++;
        }
        return totalMeows;
    }

    public static <T> List<T> findCommonElements(List<T> list1, List<T> list2) {
        // Создаем новый список для хранения общих элементов
        List<T> commonElements = new ArrayList<>();

        // Проходим по первому списку
        for (T element1 : list1) {
            // Проходим по второму списку
            for (T element2 : list2) {
                // Если элементы совпадают и еще не добавлены в commonElements
                if (element1.equals(element2) && !commonElements.contains(element1)) {
                    commonElements.add(element1);
                }
            }
        }

        return commonElements;
    }

    public static Queue<Integer> buildQueueFromList(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();

        // Добавляем элементы списка в очередь
        for (Integer element : list) {
            queue.add(element);
        }

        // Добавляем элементы списка в очередь в обратном порядке
        for (int i = list.size() - 1; i >= 0; i--) {
            queue.add(list.get(i));
        }

        return queue;
    }

    private static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
