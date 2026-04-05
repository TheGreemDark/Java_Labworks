package java_core_2026.lr4.Exercise2;
import java.util.Scanner;

public class Exp2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Ввод матрицы 3x3
        int[][] matrix = new int[3][3];
        System.out.println("Введите матрицу 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        
        // Ввод номера столбца
        System.out.print("Номер столбца (0-2): ");
        int columnIndex = in.nextInt();
        
        // Вывод столбца
        System.out.println("Столбец " + columnIndex + ":");
        for (int i = 0; i < 3; i++) {
            System.out.println(matrix[i][columnIndex]);
        }
        in.close();
    }
}