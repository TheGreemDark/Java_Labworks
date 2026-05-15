package java_core_2026.lr7;

import java.io.*;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        String fileName = "src/java_core_2026/lr7/example_file.txt";
        Scanner in = new Scanner(System.in);

        // Запись данных в файл
        System.out.println("Введите текст для записи в файл:");
        String data = in.nextLine();

        try {
            File file = new File(fileName);
            // Создаем папки, если их нет
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            try (FileOutputStream outputStream = new FileOutputStream(file)) {
                outputStream.write(data.getBytes());
                System.out.println("Данные записаны в файл: " + fileName);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Чтение данных из файла
        System.out.println("\nПопытка чтения данных");
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            
            if (bytesRead != -1) {
                String readData = new String(buffer, 0, bytesRead);
                System.out.println("Прочитанные данные: " + readData);
            } else {
                System.out.println("Файл пуст.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // Удаление файла
        System.out.println("\nУдаление файла");
        File fileToDelete = new File(fileName);
        if (fileToDelete.delete()) {
            System.out.println("Файл удален: " + fileName);
        } else {
            System.out.println("Не удалось удалить файл: " + fileName);
        }
        
        in.close();
    }
}