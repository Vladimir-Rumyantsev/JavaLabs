package LabWork5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Task_4_2 {
    public static void main(String[] args) {
        System.out.print("\nЗадание 4.2:\n");

        Scanner scanner = new Scanner(System.in);

        int N;
        while (true) {
            System.out.print("\nВведите количество участников олимпиады (число от 1 до 250): ");
            if (scanner.hasNextInt()) {
                N = scanner.nextInt();
                if (N >= 1 && N <= 250) {
                    break;
                } else {
                    System.out.print("\nПожалуйста, введите число в диапазоне от 1 до 250.");
                }
            } else {
                System.out.print("\nПожалуйста, введите число в диапазоне от 1 до 250.");
                scanner.next(); // Очистка буфера от некорректного ввода
            }
        }
        scanner.nextLine(); // Считываем пустую строку после ввода числа

        List<String[]> participants = new ArrayList<>();
        int i = 1;
        while (i <= N) {
            System.out.print("Введите данные участника номер " + i +
                    " в формате <Фамилия> <Имя> <Балл> <Балл> <Балл>: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            try {
                int score1 = Integer.parseInt(parts[2]);
                int score2 = Integer.parseInt(parts[3]);
                int score3 = Integer.parseInt(parts[4]);
                if ((parts.length != 5) || (parts[0].length() > 20) || (parts[1].length() > 15) || (score1 > 25) ||
                        (score1 < 1) || (score2 > 25) || (score2 < 1) || (score3 > 25) || (score3 < 1)) {
                    System.out.println("Неверный ввод данных для участника!");
                    continue;
                }
                participants.add(parts);
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
            int totalScore = Integer.parseInt(parts[2]) + Integer.parseInt(parts[3]) + Integer.parseInt(parts[4]);

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
