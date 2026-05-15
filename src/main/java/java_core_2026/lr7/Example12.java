package java_core_2026.lr7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите текст для записи: ");
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
            System.out.println("Запись завершена успешно.");
            System.out.println("Количество записанных символов: " + text.length());
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}