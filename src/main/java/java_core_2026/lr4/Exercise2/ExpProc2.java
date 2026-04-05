package java_core_2026.lr4.Exercise2;
import java.util.Scanner;
import java.util.InputMismatchException;
public class ExpProc2 {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[][] matrix = null;
        
        try {
            System.out.println("Вывод столбца матрицы");
            matrix = readMatrix();
            
            System.out.print("Номер столбца (0-2): ");
            int columnIndex = scanner.nextInt();
            
            printColumn(matrix, columnIndex);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Введена строка вместо числа [InputMismatchException]");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Нет столбца с таким номером [ArrayIndexOutOfBoundsException]");
        } catch (Exception e) {
            System.out.println("Error: Неожиданная ошибка: " + e.getMessage());
        } finally {
            System.out.println("Finally: Завершение программы");
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    
    private static int[][] readMatrix() {
        int[][] matrix = new int[3][3];
        System.out.println("Введите матрицу 3x3:");
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    matrix[i][j] = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода элемента [" + i + "][" + j + "]");
                    scanner.next(); // очистка буфера
                    j--; // повторный ввод
                }
            }
        }
        return matrix;
    }
    
    private static void printColumn(int[][] matrix, int columnIndex) {
        if (columnIndex < 0 || columnIndex >= matrix[0].length) {
            throw new ArrayIndexOutOfBoundsException("Номер столбца должен быть от 0 до " + (matrix[0].length - 1));
        }
        
        System.out.println("Столбец " + columnIndex + ":");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][columnIndex]);
        }
    }
}