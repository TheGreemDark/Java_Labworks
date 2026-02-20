package java_core_2026.timus;

import java.util.Scanner;

public class timus_1293 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Input from 1 to 100 inclusive - N, A, B: ");
        int N = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        
        if (N < 1 || N > 100 || A < 1 || A > 100 || B < 1 || B > 100) {
            System.out.println("Error: The numbers must be from 1 to 100 inclusive!");
            in.close();
            return;
        }

        long totalSulfide = (long) N * 2 * A * B;
        
        System.out.println(totalSulfide);
        
        in.close();
    }

}
