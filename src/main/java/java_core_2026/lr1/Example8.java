package java_core_2026.lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Input day of week: ");
        String dayOfWeek = in.nextLine();
        
        System.out.print("Input month: ");
        String month = in.nextLine();
        
        System.out.print("Input date (number): ");
        String dateNum = in.nextLine();

        System.out.printf("%s, %s, %s\n", dayOfWeek, dateNum, month);
        
        in.close();
    }
}
