package java_core_2026.lr7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        File folder = new File("src/java_core_2026/lr7/example_folder");
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " + folder.getAbsolutePath());
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getAbsolutePath());
        }

        File file = new File(folder.getAbsolutePath() + File.separator + "example_file.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getAbsolutePath());
            } else {
                System.out.println("Файл уже существует: " + file.getAbsolutePath());
            }

            //Ввод данных и запись
            Scanner in = new Scanner(System.in);
            System.out.println("Введите текст для записи в файл:");
            String text = in.nextLine();

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(text);
                System.out.println("Данные успешно записаны в файл.");
            } catch (IOException e) {
                System.out.println("Ошибка при записи: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
       
        if (file.delete()) {
            System.out.println("Файл удален: " + file.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить файл: " + file.getAbsolutePath());
        }

        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить папку: " + folder.getAbsolutePath());
        }
    }
}

