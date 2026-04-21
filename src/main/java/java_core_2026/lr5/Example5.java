package java_core_2026.lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        String string = "Напишите функцию, Которая принимает на вход список " +
                "строк и возвращает новый список, Содержащий только те строки," +
                " которые содержат заданную подстроку.";
        String substringToFind = "список";

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования :" + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = filterBySubstring(strings, substringToFind);

        System.out.println("\n" + "Строка после преобразования :" + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
