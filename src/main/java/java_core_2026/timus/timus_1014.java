package java_core_2026.timus;

import java.util.Scanner;

public class timus_1014 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input from 0 to 10^9 inclusive and not prime number: ");
        long N = in.nextLong();

        if (N < 0 || N > 1000000000) {
            System.out.print("Error: Input from 0 to 10^9 inclusive and not prime number: ");
            in.close();
            return;
        }

        if (N == 0) {
            System.out.println(10);
            in.close();
            return;
        }
        if (N == 1) {
            System.out.println(1);
            in.close();
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int d = 9; d >= 2; d--) {
            while (N % d == 0) {
                N /= d;
                sb.append(d);
            }
        }

        if (N != 1) {
            System.out.print("Error: Input from 0 to 10^9 inclusive and not prime number: ");
            in.close();
            return;
        }


        sb.reverse();
        System.out.println(sb.toString());
        in.close();
    }
}
