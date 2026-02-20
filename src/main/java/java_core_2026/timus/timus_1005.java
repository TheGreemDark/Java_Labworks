package java_core_2026.timus;

import java.util.Scanner;

public class timus_1005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Input from 1 to 20 inclusive: ");
        int n = in.nextInt();
        if (n < 1 || n > 20) {
            System.out.println("Error: The numbers must be from 1 to 20 inclusive!");
            in.close();
            return;
        }
        int[] weights = new int[n];
        int totalSum = 0;
        
        System.out.print("Input from 1 to 100000 inclusive: ");
        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
        if (weights[i] < 1 || weights[i] > 100000) {
            System.out.println("Error: The numbers must be from 1 to 100000 inclusive!");
            in.close();
            return;
        }    
            totalSum += weights[i];
        }
        
        int minDiff = Integer.MAX_VALUE;
        boolean[] possible = new boolean[totalSum + 1];
        possible[0] = true;
        
        for (int weight : weights) {
            for (int j = totalSum; j >= weight; j--) {
                if (possible[j - weight]) {
                    possible[j] = true;
                }
            }
        }
        
        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (possible[s1]) {
                int s2 = totalSum - s1;
                minDiff = Math.min(minDiff, Math.abs(s1 - s2));
            }
        }
        
        System.out.println(minDiff);
        in.close();
    }
    

}
