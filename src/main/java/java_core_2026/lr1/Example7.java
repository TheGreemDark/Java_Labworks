package java_core_2026.lr1;

import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        System.out.println("Input name: ");        
        String name = in.nextLine();        
        System.out.println("Input age: ");        
        int age = in.nextInt();
        String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        
        System.out.printf("%s, you are %d years old!\n", formattedName, age);
        
        in.close();
    }

}
