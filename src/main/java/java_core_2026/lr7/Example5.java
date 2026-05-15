package java_core_2026.lr7;

import java.io.*;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        String inputFileName = "src/main/java/java_core_2026/lr7/input.txt";
        String outputFileName = "src/main/java/java_core_2026/lr7/output.txt";
        Scanner in = new Scanner(System.in);

        // Ввод данных с консоли и запись в исходный файл
        System.out.println("Введите текст (для завершения нажмите Enter на пустой строке):");
        try (PrintWriter writer = new PrintWriter(new FileWriter(inputFileName))) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.isEmpty()) break;
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи входного файла: " + e.getMessage());
        }

        // Чтение из input.txt, перевод в верхний регистр и запись в output.txt
        try (InputStream inputStream = new FileInputStream(inputFileName);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             OutputStream outputStream = new FileOutputStream(outputFileName);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }
            System.out.println("Данные записаны в файл: " + outputFileName);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}