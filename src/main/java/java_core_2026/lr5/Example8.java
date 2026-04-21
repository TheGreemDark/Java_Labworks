package java_core_2026.lr5;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
public class Example8 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        int threshold = 500; // Заданное значение для фильтрации

        System.out.println("\n" + "Список до: " + "\n");
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(1000));
            System.out.println(integers.get(i));
        }

        List<Integer> integersAfter = filterByThreshold(integers, threshold);

        System.out.println("\n" + "Список после фильтрации (больше заданного числа " + threshold + "): " + "\n");
        for (Integer i : integersAfter) {
            System.out.println(i);
        }
    }

    public static List<Integer> filterByThreshold(List<Integer> list, int threshold) {
        // Проверка на null для входного списка
        if (list == null) {
            throw new IllegalArgumentException("Входной список не может быть null.");
        }
        return list.stream()
                .filter(number -> number > threshold) // Фильтрация чисел, которые больше threshold
                .collect(Collectors.toList());
    }
}
