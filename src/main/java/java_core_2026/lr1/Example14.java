package java_core_2026.lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Input number: ");
        int number = in.nextInt();
        
        int first = number - 1;
        int second = number;
        int third = number + 1;
        int fourth = (first + second + third) * (first + second + third);
        
        System.out.printf("Sequence: %d, %d, %d, %d\n", first, second, third, fourth);
        
        in.close();
    }

}
