package java_core_2026.lr3.Example9;
import java.util.HashMap;

public class Example9 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        // Заполнение HashMap 10 объектами
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(16, "sixteen");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nineteen");

        // Нахождение строк, где ключ превышает 5
        System.out.println("Строки с ключом превышающим 5:");
        for (Integer key : map.keySet()) {
            if (key > 5) {
                System.out.println(map.get(key));
            }
        }

        // Если ключ = 0, вывести строки через запятую
        if (map.containsKey(0)) {
            System.out.println("\nСтрока для ключа 0: " + map.get(0));
        }

        // Перемножение всех ключей, где длина строки превышает 5
        int product = 1;
        boolean found = false;
        for (Integer key : map.keySet()) {
            if (map.get(key).length() > 5) {
                product *= key;
                found = true;
            }
        }
        // Проверка условий
        if (found) {
            System.out.println("\nПроизведение ключей, где длина строки превышает 5: " + product);
        } else {
            System.out.println("\nНет строк с длиной превышающей 5");
        }
    }
}