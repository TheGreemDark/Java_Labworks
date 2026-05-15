package java_core_2026.lr7;
import java.io.*;
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        String fileName = "src/java_core_2026/lr7/example_file.txt";
        Scanner in = new Scanner(System.in);

        // Запись данных в файл
        System.out.println("Введите текст для записи:");
        String data = in.nextLine();

        try {
            // Создаем папки, если их нет
            File file = new File(fileName);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(data);
                System.out.println("Данные записаны в файл: " + fileName);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Чтение данных из файла
        System.out.println("\nЧтение данных из файла");
        try (FileReader reader = new FileReader(fileName)) {
            char[] buffer = new char[1024];
            int charRead = reader.read(buffer);
            
            if (charRead != -1) {
                String readData = new String(buffer, 0, charRead);
                System.out.println("Прочитанные данные: " + readData);
            } else {
                System.out.println("Файл пуст.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // Удаление файла
        System.out.println("\nУдаление файла");
        if (new File(fileName).delete()) {
            System.out.println("Файл удален: " + fileName);
        } else {
            System.out.println("Не удалось удалить файл: " + fileName);
        }

        in.close();
    }
}