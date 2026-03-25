package java_core_2026.lr3.Example10;
import java.util.Iterator;
import java.util.LinkedList;
public class Test2 {
public static int last(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        Iterator<Integer> it = list.iterator();
        while (list.size() > 1) {
            if (!it.hasNext()) it = list.iterator();  // Цикл по кругу
            it.next();  // Пропустить одного
            if (!it.hasNext()) it = list.iterator();
            it.next();  // Второй человек - вычёркивается
            it.remove();
        }

        return list.getFirst();
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Оставшийся (LinkedList): " + last(n));
    }
}