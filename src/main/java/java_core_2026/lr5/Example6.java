package java_core_2026.lr5;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
public class Example6 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        int divisor = 5; // Заданное число для проверки делимости

        System.out.println("\n" + "Список до: " + "\n");
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(1000));
            System.out.println(integers.get(i));
        }

        List<Integer> integersAfter = filterByDivisibility(integers, divisor);

        System.out.println("\n" + "Список после фильтрации (делятся на " + divisor + "): " + "\n");
        for (Integer i : integersAfter) {
            System.out.println(i);
        }
    }

    public static List<Integer> filterByDivisibility(List<Integer> list, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Делитель не может быть равен нулю.");
        }
        return list.stream()
                .filter(number -> number % divisor == 0) // Проверка делимости на заданное число
                .collect(Collectors.toList());
    }
}