package java_core_2026.timus.lr2;

import java.util.Scanner;

public class timus_1009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число N при условии, что N >= 2");
        int N = in.nextInt(); // количество цифр
        System.out.println("Введите число K при условии, что 2 <= K <= 10 и N + K <= 18");
        int K = in.nextInt(); // основание системы
        if (N < 2 || K < 2 || K > 10 || N + K > 18) {
            System.out.println("Error: Ограничения: 2 <= K <= 10; N >= 2; N + K <= 18");
            in.close();
            return;
        }

        long result = solve(N, K);
        System.out.println(result);
        in.close();
    }
    
    static long solve(int n, int k) {
        // dp[i][prev_zero] = количество правильных чисел длины i
        // prev_zero = 1 если предыдущая цифра была 0
        long[][] dp = new long[n + 1][2];
        
        // База: 1 цифра
        dp[1][0] = k - 1;
        dp[1][1] = 1;
        
        // Для длин от 2 до n
        for (int i = 2; i <= n; i++) {
            // Если предыдущая цифра НЕ 0
            dp[i][0] = dp[i-1][0] * (k - 1) + dp[i-1][1] * (k - 1);
            // Если предыдущая цифра БЫЛА 0, то текущая НЕ может быть 0
            dp[i][1] = dp[i-1][0] * 1; // только цифра 0 после НЕ-0
        }
        
        // Ответ: первая цифра != 0, поэтому берем только dp[n][0]
        return dp[n][0];
    }
}
