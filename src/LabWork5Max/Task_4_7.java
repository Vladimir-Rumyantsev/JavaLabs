package LabWork5Max;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Task_4_7 {
    public static void main(String[] args) {

        System.out.print("Задание 4.7:\n\nВведите N (число АЗС): ");

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String[]> inputData = new ArrayList<>();

        int i = 1;
        while (i <= N) {
            System.out.print("Введите данные для АЗС номер " + i +
                    " в формате <Компания> <Улица> <Марка> <Цена>: ");
            String input = scanner.nextLine();
            String[] gasStation = input.split(" ");
            try {
                int brand = Integer.parseInt(gasStation[2]);
                int price = Integer.parseInt(gasStation[3]);
                if ((gasStation.length != 4) || (gasStation[0].length() > 20) || (gasStation[1].length() > 20) ||
                        !(Arrays.asList(92, 95, 98).contains(brand)) || (price < 1000) || (price > 3000)) {
                    System.out.println("Неверный ввод данных для АЗС!\n" +
                            "Программа ожидает увидеть формат данных <Компания> <Улица> <Марка> <Цена>, " +
                            "где <Компания> и <Улица> - строки не длиннее 20 символов, " +
                            "<Марка> - одно из чисел [92, 95, 98], а <Цена> - число в диапазоне от 1000 до 3000, " +
                            "обозначающее стоимость одного литра бензина в копейках\n");
                    continue;
                }
                inputData.add(gasStation);
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод данных для АЗС!\n" +
                        "Программа ожидает увидеть формат данных <Компания> <Улица> <Марка> <Цена>, " +
                        "где <Компания> и <Улица> - строки не длиннее 20 символов, " +
                        "<Марка> - одно из чисел [92, 95, 98], а <Цена> - число в диапазоне от 1000 до 3000, " +
                        "обозначающее стоимость одного литра бензина в копейках\n");
            }
        }

        int[] minPrices = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] countCheapest = {0, 0, 0};

        for (String[] gasStation : inputData) {
            int brand = Integer.parseInt(gasStation[2]);
            int price = Integer.parseInt(gasStation[3]);

            int index = brand == 92 ? 0 : (brand == 95 ? 1 : 2);

            if (price < minPrices[index]) {
                minPrices[index] = price;
                countCheapest[index] = 1;
            } else if (price == minPrices[index]) {
                countCheapest[index]++;
            }
        }

        System.out.println(countCheapest[0] + " " + countCheapest[1] + " " + countCheapest[2]);
    }
}
