package java_core_2026.lr8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите путь к Excel файлу или 'exit' для выхода: ");
            String filePath = scanner.nextLine();

            if ("exit".equalsIgnoreCase(filePath)) {
                System.out.println("Завершение программы.");
                break;
            }

            try (FileInputStream inputStream = new FileInputStream(filePath);
                 Workbook workbook = new XSSFWorkbook(inputStream)) {

                if (workbook.getNumberOfSheets() == 0) {
                    System.err.println("В файле отсутствуют листы. Проверьте содержимое файла.");
                    continue;
                }

                Sheet sheet = workbook.getSheetAt(0);
                if (sheet == null) {
                    System.err.println("Первый лист не найден в файле. Возможно, файл поврежден.");
                    continue;
                }

                System.out.println("Чтение данных из листа: " + sheet.getSheetName());

                for (Row row : sheet) {
                    for (Cell cell : row) {
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }
                
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
