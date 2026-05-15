package java_core_2026.lr7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/java_core_2026/lr7/input.txt";
        Scanner in = new Scanner(System.in);

        // Запись данных из консоли в файл
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        System.out.println("Введите текст (для завершения введите 'exit'):");
        
        while (true) {
            String line = in.nextLine();
            if (line.equals("exit")) break;
            writer.write(line);
            writer.newLine();
        }
        writer.close();

        // Чтение и подсчет строк
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        reader.close();

        System.out.println("Количество строк в файле: " + lineCount);
        in.close();
    }
}