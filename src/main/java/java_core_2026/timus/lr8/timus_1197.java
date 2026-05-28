package java_core_2026.timus.lr8;

import java.util.Scanner;

public class timus_1197 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

        for (int i = 0; i < n; i++) {
            String pos = sc.next();
            int col = pos.charAt(0) - 'a';
            int row = pos.charAt(1) - '1';
            int count = 0;
            for (int j = 0; j < 8; j++) {
                int nextCol = col + dx[j];
                int nextRow = row + dy[j];
                if (nextCol >= 0 && nextCol < 8 && nextRow >= 0 && nextRow < 8) {
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}

