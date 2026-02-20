package java_core_2026.lr1;

import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Input first number: ");
        int firstNumber = in.nextInt();
        
        System.out.print("Input second number: ");
        int secondNumber = in.nextInt();
        
        int sum = firstNumber + secondNumber;
        
        System.out.printf("Sum %d + %d = %d\n", firstNumber, secondNumber, sum);
        
        in.close();
    }

}
