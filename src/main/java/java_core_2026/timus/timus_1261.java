package java_core_2026.timus;

import java.util.Scanner;

public class timus_1261 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input from 1 to 10^7 inclusive: ");
        long N = in.nextLong();

         if (N < 1 || N > 10000000) {
            System.out.println("Error: The numbers must be from 1 to 10^7 inclusive!");
            in.close();
            return;
        }

        long tips = 4;
        long payment = N + tips;
        
        if (payment <= 4294967291L) {
            System.out.printf("%d %d\n", payment, tips);
        } else {
            System.out.println(0);
        }
        
        in.close();
    }
}
