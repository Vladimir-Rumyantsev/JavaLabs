package LabWork2;

public class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Метод для добавления нового узла в начало списка
    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Метод для вывода элементов списка
    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Добавляем элементы в список
        list.add(1);
        list.add(2);
        list.add(3);

        // Выводим элементы списка
        list.printList();
    }
}
