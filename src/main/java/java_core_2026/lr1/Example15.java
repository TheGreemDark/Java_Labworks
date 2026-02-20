package java_core_2026.lr1;

import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input first number: ");
        int firstNumber = scanner.nextInt();
        
        System.out.print("Input second number: ");
        int secondNumber = scanner.nextInt();
        
        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;
        
        System.out.printf("Sum: %d + %d = %d\n", firstNumber, secondNumber, sum);
        System.out.printf("Difference: %d - %d = %d\n", firstNumber, secondNumber, difference);
        
        scanner.close();
    }

}
