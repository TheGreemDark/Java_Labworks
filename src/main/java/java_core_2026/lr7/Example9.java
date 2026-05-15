package java_core_2026.lr7;

import java.io.*;
import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) throws IOException {
        // Пути по дефолту
        String filereader = "src/main/java/java_core_2026/lr7/input.txt";
        String filewriter = "src/main/java/java_core_2026/lr7/output.txt";

        // Запись данных из консоли в исходный файл
        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(filereader)) {
            
            System.out.println("Введите текст (для завершения введите 'exit'):");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("exit")) break;
                writer.write(line + System.lineSeparator());
            }
        }

        // Копирование файла
        try (InputStream in = new FileInputStream(filereader);
             OutputStream out = new FileOutputStream(filewriter)) {
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }

        System.out.println("Файл создан: " + filereader);
        System.out.println("Файл скопирован в: " + filewriter);
    }
}