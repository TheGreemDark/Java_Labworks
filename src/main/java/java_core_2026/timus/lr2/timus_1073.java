package java_core_2026.timus.lr2;

import java.util.Arrays;
import java.util.Scanner;

public class timus_1073 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число N, что N <= 60000");
        int N = in.nextInt();
        if (N > 60000) {
            System.out.println("Error: Ограничения: N <= 60000");
            in.close();
            return;
        }
        in.close();
        
        int minCertificates = minimizeCertificates(N);
        System.out.println(minCertificates);
    }
    
    // Находит минимальное количество квадратов, сумма которых = N
    public static int minimizeCertificates(int n) {
        int minCount = Integer.MAX_VALUE;
        
        // Перебираем возможные размеры крупнейшего квадрата (от большего к меньшему)
        for (int a = (int) Math.sqrt(n); a >= 1; a--) {
            int squareA = a * a;
            if (squareA > n) continue;
            
            // Рекурсивно решаем для остатка
            int remainder = n - squareA;
            int countWithA = 1 + minimizeCertificatesRecursive(remainder);
            
            if (countWithA < minCount) {
                minCount = countWithA;
            }
            
            // Если уже нашли 1 или 2 квадрата, дальше не улучшим
            if (minCount <= 2) {
                break;
            }
        }
        
        return minCount;
    }
    
    // Рекурсивная функция с мемоизацией
    private static int[] memo = new int[60001];
    
    static {
        Arrays.fill(memo, -1);
        memo[0] = 0;
    }
    
    private static int minimizeCertificatesRecursive(int n) {
        if (n == 0) return 0;
        if (memo[n] != -1) return memo[n];
        
        int minCount = Integer.MAX_VALUE;
        
        // Перебираем размер квадрата
        for (int a = (int) Math.sqrt(n); a >= 1; a--) {
            int squareA = a * a;
            if (squareA > n) continue;
            
            int count = 1 + minimizeCertificatesRecursive(n - squareA);
            if (count < minCount) {
                minCount = count;
            }
            
            // Теорема Лагранжа: любое число = сумма ≤4 квадратов
            if (minCount <= 3) break;
        }
        
        memo[n] = minCount;
        return minCount;
    }
}
