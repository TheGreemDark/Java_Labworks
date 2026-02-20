package java_core_2026.lr1;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        System.out.println("Input last name: ");        
        String surname = in.nextLine();       
        System.out.println("Input name: ");        
        String name = in.nextLine();       
        System.out.println("Input middle name: ");
        String patronymic = in.nextLine();        
        String fullName = surname + " " + name + " " + patronymic;
        
        System.out.println("Hello " + fullName + "!");       
        in.close();
    }

}
