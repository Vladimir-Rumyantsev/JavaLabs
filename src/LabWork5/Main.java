package LabWork5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String filePath = "src/LabWork5/file.txt";


        // Задание 2.1

        System.out.println("\nЗадание 2.1:\n");
        Cat cat = new Cat("Васька");
        cat.meow();
        System.out.println();
        int meowCount = meowsCare(cat, cat, cat, cat, cat); // Вызываем метод 5 раз
        System.out.println("\nВнутри метода кот мяукал " + meowCount +
                " раз\nВсего кот мяукал " + cat.getMeowCount() + " раз");


        // Задание 3.2

        System.out.println("\n----------------------------------------------------------------\n\nЗадание 3.2:\n");
        List<Integer> L = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> L1 = new ArrayList<>(List.of(4, 5, 6));
        List<Integer> L2 = new ArrayList<>(List.of(10, 11, 12));

        List<Integer> result = replaceFirstOccurrence(L, L1, L2);
        System.out.println(result); // Вывод: [1, 2, 3, 10, 11, 12, 7, 8, 9]


        // Задание 4.2

        System.out.print("\n----------------------------------------------------------------\n" +
                "\nЗадание 4.2:\n\nВведите количество участников олимпиады: ");

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        while (N > 250 || N < 1) {
            System.out.print("Пожалуйста, введите число от 1 до 250: ");
            N = scanner.nextInt();
        }
        scanner.nextLine(); // Считываем пустую строку после ввода числа

        List<String[]> participants = new ArrayList<>();
        int i = 1;
        while (i <= N) {
            System.out.print("Введите данные участника номер " + i +
                    " в формате <Фамилия> <Имя> <Балл> <Балл> <Балл>: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            if (parts.length != 5) {
                System.out.println("Неверный ввод данных для участника!");
                continue;
            }
            try {
                int score1 = Integer.parseInt(parts[2]);
                int score2 = Integer.parseInt(parts[3]);
                int score3 = Integer.parseInt(parts[4]);
                participants.add(new String[]{parts[0], parts[1], String.valueOf(score1), String.valueOf(score2), String.valueOf(score3)});
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод данных для участника!");
            }
        }

        int maxScore = -1;
        List<String> topParticipants = new ArrayList<>();

        for (String[] parts : participants) {
            String lastName = parts[0];
            String firstName = parts[1];
            int score1 = Integer.parseInt(parts[2]);
            int score2 = Integer.parseInt(parts[3]);
            int score3 = Integer.parseInt(parts[4]);
            int totalScore = score1 + score2 + score3;

            if (totalScore > maxScore) {
                maxScore = totalScore;
                topParticipants.clear();
                topParticipants.add(lastName + " " + firstName);
            } else if (totalScore == maxScore) {
                topParticipants.add(lastName + " " + firstName);
            }
        }

        System.out.println("Участники, набравшие максимальное количество баллов:");
        for (String participant : topParticipants) {
            System.out.println(participant);
        }


        // Задание 5.2

        Set<Character> allConsonants = new HashSet<>();
        allConsonants.add('к');
        allConsonants.add('п');
        allConsonants.add('с');
        allConsonants.add('т');
        allConsonants.add('ф');
        allConsonants.add('х');
        allConsonants.add('ц');
        allConsonants.add('ш');

        Set<Character> usedConsonants = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (allConsonants.contains(Character.toLowerCase(c))) {
                        usedConsonants.add(Character.toLowerCase(c));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        allConsonants.removeAll(usedConsonants);

        Set<Character> sortedConsonants = new TreeSet<>(allConsonants);

        System.out.print("Глухие согласные буквы, которые не входят ни в одно слово: ");
        for (char c : sortedConsonants) {
            System.out.print(c + " ");
        }


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

    public static List<Integer> replaceFirstOccurrence(List<Integer> L, List<Integer> L1, List<Integer> L2) {
        for (int i = 0; i <= L.size() - L1.size(); i++) {
            if (L.subList(i, i + L1.size()).equals(L1)) {
                List<Integer> newList = new ArrayList<>(L);
                newList.subList(i, i + L1.size()).clear();
                newList.addAll(i, L2);
                return newList;
            }
        }
        return L;
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
