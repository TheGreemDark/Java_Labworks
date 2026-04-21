package java_core_2026.lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Example9 {
    public static void main(String[] args) {
        String string = "Напишите12 функцию12, Кот6орая: прин4имает на/ вхо/д список** " +
                "строк3 5и5 возвращает новый список27, 7Содержащий 7только 6те 9строки," +
                " /которые /содержат /только /буквы (без цифр и символов).";

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования :" + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> filteredStrings = filterOnlyLetters(strings);

        System.out.println("\n" + "Список строк, содержащих только буквы: " + "\n");
        for (String e : filteredStrings) {
            System.out.println(e);
        }
    }

    public static List<String> filterOnlyLetters(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Входной список не может быть null.");
        }

        return list.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-ЯёЁ]+")) // Фильтрация строк, состоящих только из букв (латиница и кириллица)
                .collect(Collectors.toList());
    }
}