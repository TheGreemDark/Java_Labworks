package java_core_2026.lr1;

import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Input how old are you: ");
        int birthYear = in.nextInt();
        
        int currentYear = 2026;
        int age = currentYear - birthYear;
        
        System.out.printf("Yours birth year %d!\n", age);
        
        in.close();
    }

}
