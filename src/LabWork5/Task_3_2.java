package LabWork5;

import java.util.ArrayList;
import java.util.List;

public class Task_3_2 {
    public static void main(String[] args) {
        System.out.println("\nЗадание 3.2:\n");
        List<Integer> L = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> L1 = new ArrayList<>(List.of(4, 5, 6));
        List<Integer> L2 = new ArrayList<>(List.of(10, 11, 12));

        List<Integer> result = replaceFirstOccurrence(L, L1, L2);
        System.out.println(L);
        System.out.println(L1);
        System.out.println(L2 + "\n");
        System.out.println(result); // Вывод: [1, 2, 3, 10, 11, 12, 7, 8, 9]
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
}
