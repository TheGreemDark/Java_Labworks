package java_core_2026.lr7;

import java.io.File;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите название файла: ");
        String fileName = in.nextLine();

        File file = new File(fileName);

        if (file.exists() && file.isFile()) {
            long bytes = file.length();
            System.out.println("Размер файла: " + bytes + " байт");
        } else {
            System.out.println("Ошибка: Файл не найден или это директория.");
        }

        in.close();
    }
}