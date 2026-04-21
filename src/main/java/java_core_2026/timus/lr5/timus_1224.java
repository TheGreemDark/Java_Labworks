package java_core_2026.timus.lr5;
import java.util.Scanner;
public class timus_1224 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int turns = 0;
        if (n == 1 || m == 1) {
            turns = 0;
        } else {
            int totalCells = n * m;
            int currentCellsCleared = 0;

            int topRow = 0;
            int bottomRow = n - 1;
            int leftCol = 0;
            int rightCol = m - 1;

            while (currentCellsCleared < totalCells) {
                for (int c = leftCol; c <= rightCol; c++) {
                    if (currentCellsCleared < totalCells) {
                        currentCellsCleared++;
                    } else {
                        break;
                    }
                }
                if (currentCellsCleared == totalCells) break;
                turns++;
                topRow++;
                for (int r = topRow; r <= bottomRow; r++) {
                    if (currentCellsCleared < totalCells) {
                        currentCellsCleared++;
                    } else {
                        break;
                    }
                }
                if (currentCellsCleared == totalCells) break;
                turns++;
                rightCol--;
                for (int c = rightCol; c >= leftCol; c--) {
                    if (currentCellsCleared < totalCells) {
                        currentCellsCleared++;
                    } else {
                        break;
                    }
                }
                if (currentCellsCleared == totalCells) break;
                turns++;
                bottomRow--;
                for (int r = bottomRow; r >= topRow; r--) {
                    if (currentCellsCleared < totalCells) {
                        currentCellsCleared++;
                    } else {
                        break;
                    }
                }
                if (currentCellsCleared == totalCells) break;
                turns++;
                leftCol++;
            }
        }
        System.out.println(turns);
        in.close();
    }
}