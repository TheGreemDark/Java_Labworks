package java_core_2026.lr7;

import java.io.*;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        String inputFileName = "src/main/java/java_core_2026/lr7/input.txt";
        String outputFileName = "src/main/java/java_core_2026/lr7/output.txt";

        // Ввод данных с консоли в файл
        try (Scanner in = new Scanner(System.in);
             PrintWriter fileWriter = new PrintWriter(new FileWriter(inputFileName))) {
            System.out.println("Введите текст:");
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.isEmpty()) break;
                fileWriter.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи входного файла: " + e.getMessage());
        }

        // Чтение из файла и запись в верхнем регистре
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
             PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(
                     new FileOutputStream(outputFileName), "UTF-8"))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line.toUpperCase());
            }
            System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}

