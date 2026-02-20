package java_core_2026.lr1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Input month: ");
        String month = in.nextLine();
        
        System.out.print("Input quantity of days in this month: ");
        int days = in.nextInt();
        
        System.out.printf("%s have %d days.\n", month, days);
        
        in.close();
    }

}
