package java_core_2026.lr7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        String fileName = input.nextLine();

        System.out.print("Введите слово для поиска: ");
        String word = input.nextLine();

        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            boolean found = false;
            int lineNumber = 1;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains(word)) {
                    System.out.println("Строка " + lineNumber + ": " + line);
                    found = true;
                }
                lineNumber++;
            }

            if (!found) {
                System.out.println("Слово не найдено.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден.");
        }

        input.close();
    }
}

