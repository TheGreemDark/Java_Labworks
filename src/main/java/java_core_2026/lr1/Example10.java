package java_core_2026.lr1;

import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Input yours birth year: ");
        int birthYear = in.nextInt();
        
        int currentYear = 2026;
        int age = currentYear - birthYear;
        
        System.out.printf("you are %d years old!\n", age);
        
        in.close();
    }

}
