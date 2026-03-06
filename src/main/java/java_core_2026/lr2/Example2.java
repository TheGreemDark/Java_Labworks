package java_core_2026.lr2;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        int rows = 9;    // число строк
        int cols = 9;    // число столбцов
        int[][] arr = new int[rows][cols];

        int num = 1;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                // Чётная строка (0, 2, 4...) - слева направо
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = num++;
                }
            } else {
                // Нечётная строка (1, 3, 5...) - справа налево
                for (int j = cols - 1; j >= 0; j--) {
                    arr[i][j] = num++;
                }
            }
        }

        // Вывод результата
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
        id.close();
    }
}
