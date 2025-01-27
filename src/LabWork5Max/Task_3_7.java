package LabWork5Max;

import java.util.ArrayList;
import java.util.List;

public class Task_3_7 {
    public static void main(String[] args) {

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
}
