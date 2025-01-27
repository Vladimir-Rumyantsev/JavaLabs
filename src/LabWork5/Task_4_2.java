package LabWork5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_4_2 {
    public static void main(String[] args) {
        System.out.print("\nЗадание 4.2:\n\nВведите количество участников олимпиады: ");

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
    }
}
