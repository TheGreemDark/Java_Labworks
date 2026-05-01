package java_core_2026.timus.lr6;

import java.util.Scanner;
import java.util.Locale;

public class timus_1263 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        if (!in.hasNextInt()) return;
        int n = in.nextInt();
        int m = in.nextInt();
        int[] votes = new int[n + 1];
        for (int i = 0; i < m; i++) {
            if (in.hasNextInt()) {
                int candidate = in.nextInt();
                if (candidate >= 1 && candidate <= n) {
                    votes[candidate]++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            double percentage = (votes[i] * 100.0) / m;
            
            // Форматируем вывод: 2 знака после точки и символ %
            System.out.printf(Locale.US, "%.2f%%%n", percentage);
        }
        in.close();
    }
}