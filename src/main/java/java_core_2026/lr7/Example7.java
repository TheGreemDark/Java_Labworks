package java_core_2026.lr7;

import java.io.*;
import java.util.Scanner;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

public class Example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = in.nextLine();

        System.out.print("Введите возраст: ");
        int age = in.nextInt();

        Person person = new Person(name, age);

        try (FileOutputStream fileOut = new FileOutputStream("src/main/java/java_core_2026/lr7/person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            
            out.writeObject(person);
            System.out.println("Serialized data is saved in person.ser");
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
