package java_core_2026.lr3.Example11;

public class Test2 {
     public static void main(String[] args) {
        System.out.println("С хвоста");
        
        // Создание несвязанных узлов
        Node node0 = new Node(0, null); // будущая голова
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null); // будущий хвост
        
        // Связывание узлов с хвоста к голове
        node2.next = node3;
        node1.next = node2;
        node0.next = node1;
        
        // Вывод списка
        Node ref = node0;
        System.out.print("Список: ");
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
        System.out.println();
    }
}