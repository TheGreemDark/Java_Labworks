package java_core_2026.lr3.Example12;
import java.util.Scanner;
public class Example12 {
    private Node head;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Scanner in = new Scanner(System.in);

    // а) Методы с использованием цикла

    // Ввод с головы (цикл)
    public void createHead() {
        System.out.println("Введите количество элементов для createHead:");
        int n = in.nextInt();
        head = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент #" + (i + 1) + ": ");
            addFirst(in.nextInt());
        }
    }

    // Ввод с хвоста (цикл)
    public void createTail() {
        System.out.println("Введите количество элементов для createTail:");
        int n = in.nextInt();
        head = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент #" + (i + 1) + ": ");
            addLast(in.nextInt());
        }
    }

    // toString() - вывод в строку
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append("  ");
            current = current.next;
        }
        return sb.toString();
    }

    // Добавление в начало списка
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Добавление в конец списка
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null)
            current = current.next;
        current.next = newNode;
    }

    // Вставка по индексу (номер начинается с 0)
    public void insert(int index, int data) {
        if (index < 0) {
            System.out.println("Некорректный индекс");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                System.out.println("Индекс вне диапазона");
                return;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println("Индекс вне диапазона");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Удаление с головы
    public void removeFirst() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }
        head = head.next;
    }

    // Удаление с хвоста
    public void removeLast() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null)
            current = current.next;
        current.next = null;
    }
    // Удаление по индексу (номер начинается с 0)
    public void remove(int index) {
        if (index < 0 || head == null) {
            System.out.println("Некорректный индекс или пустой список");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) {
                System.out.println("Индекс вне диапазона");
                return;
            }
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Индекс вне диапазона");
            return;
        }
        current.next = current.next.next;
    }

    // б) Методы с использованием рекурсии

    // Ввод с головы (рекурсия)
    public void createHeadRec(int n) {
        if (n <= 0) return;
        System.out.print("Введите элемент для createHeadRec: ");
        int data = in.nextInt();
        addFirst(data);
        createHeadRec(n - 1);
    }

    // Ввод с хвоста (рекурсия)
    public void createTailRec(int n) {
        if (n <= 0) return;
        System.out.print("Введите элемент для createTailRec: ");
        int data = in.nextInt();
        addLast(data);
        createTailRec(n - 1);
    }

    // Вывод рекурсия
    public String toStringRec() {
        return toStringRecHelper(head);
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "null";
        if (node.next == null) return String.valueOf(node.data);
        return node.data + "  " + toStringRecHelper(node.next);
    }
    
    // Тестирование методов
    public static void main(String[] args) {
        Example12 list = new Example12();

        // Демонстрация циклических методов
        System.out.println("Ввод с головы с циклом");
        list.createHead();

        System.out.println("Список: " + list.toString());

        System.out.println("Добавление 100 в начало");
        list.addFirst(100);
        System.out.println("Список: " + list.toString());

        System.out.println("Добавление 200 в конец");
        list.addLast(200);
        System.out.println("Список: " + list.toString());

        System.out.println("Вставка 150 на позицию 2");
        list.insert(2, 150);
        System.out.println("Список: " + list.toString());

        System.out.println("Удаление первого элемента");
        list.removeFirst();
        System.out.println("Список: " + list.toString());

        System.out.println("Удаление последнего элемента");
        list.removeLast();
        System.out.println("Список: " + list.toString());

        System.out.println("Удаление элемента на позиции 1");
        list.remove(1);
        System.out.println("Список: " + list.toString());

        // Демонстрация рекурсивных методов
        System.out.println("\nВвод с хвоста с рекурсией");
        System.out.println("Введите количество элементов для createTailRec:");
        int n = list.in.nextInt();
        list.head = null;  // очистить список
        list.createTailRec(n);
        System.out.println("Список (рекурсивный вывод): " + list.toStringRec());
    }
}
