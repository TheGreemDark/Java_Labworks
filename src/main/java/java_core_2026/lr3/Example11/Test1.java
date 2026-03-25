package java_core_2026.lr3.Example11;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("С головы");
        
        // Добавление элементов с перемещением головы (наращивание с головы)
        Node head = null; // начальное значение ссылки на голову
        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }
        
        // Вывод элементов
        Node ref = head;
        System.out.print("Список: ");
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
        System.out.println();
    }
}