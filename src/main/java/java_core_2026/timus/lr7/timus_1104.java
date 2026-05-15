package java_core_2026.timus.lr7;

import java.util.Scanner;

public class timus_1104 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String s = sc.next();
        for (int k = 2; k <= 36; k++) {
            long sumOfDigits = 0;
            boolean possible = true;
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int digit;
                if (c >= '0' && c <= '9') {
                    digit = c - '0';
                } else {
                    digit = c - 'A' + 10;
                }
                if (digit >= k) {
                    possible = false;
                    break;
                }
                sumOfDigits += digit;
            }
            
            if (possible && sumOfDigits % (k - 1) == 0) {
                System.out.println(k);
                return;
            }
        }
        
        System.out.println("No solution.");
    }
}