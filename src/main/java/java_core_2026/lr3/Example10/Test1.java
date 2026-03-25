package java_core_2026.lr3.Example10;
import java.util.ArrayList;
public class Test1 {
    public static int last(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            // каждый второй человек вычеркивается
            index = (index + 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Оставшийся (ArrayList): " + last(n));
    }
}