package java_core_2026.lr3.Example6;

class Node { // КЛАСС — СТРУКТУРА ЭЛЕМЕНТА СПИСКА
    public int value; // значение
    public Node next; // поле — ссылка (указатель) на следующий узел

    Node(int value, Node next) { // конструктор класса
        this.value = value;
        this.next = next;
    }
}