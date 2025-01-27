package LabWork5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Task_6_2 {
    public static void main(String[] args) {
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
    }

    public static Queue<Integer> buildQueueFromList(List<Integer> list) {

        // Добавляем элементы списка в очередь
        Queue<Integer> queue = new LinkedList<>(list);

        // Добавляем элементы списка в очередь в обратном порядке
        for (int i = list.size() - 1; i >= 0; i--) {
            queue.add(list.get(i));
        }

        return queue;
    }
}
