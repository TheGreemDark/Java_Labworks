package java_core_2026.lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Example7 {
    public static void main(String[] args) {
        String string = "Напишите функцию, Которая принимает на вход список " +
                "строк и возвращает новый список, Содержащий только те строки," +
                " которые имеют длину больше заданного значения.";
        int minLength = 8; // Заданное минимальное значение длины

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования :" + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> filteredWords = filterByLength(strings, minLength);

        System.out.println("\n" + "Список строк после фильтрации (длина больше " + minLength + "): " + "\n");
        for (String e : filteredWords) {
            System.out.println(e);
        }
    }

    public static List<String> filterByLength(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength) // Фильтруем строки по длине
                .collect(Collectors.toList());
    }
}
