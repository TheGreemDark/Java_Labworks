package java_core_2026.lr7;

import java.io.*;
import java.util.Scanner;

// Класс с несколькими полями и интерфейсом Serializable
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

public class Example13{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String filePath = "src/main/java/java_core_2026/lr7/person.ser";

        System.out.print("Введите имя: ");
        String name = in.nextLine();
        System.out.print("Введите возраст: ");
        int age = in.nextInt();

        Person person = new Person(name, age);

        // Запись объекта в файл (ObjectOutputStream)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(person);
            System.out.println("Serialized data is saved in " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Восстановление объекта из файла (ObjectInputStream)
        try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Person restoredPerson = (Person) inStream.readObject();
            
            // Вывод значений полей на экран
            System.out.println("Восстановленные данные");
            System.out.println("Имя: " + restoredPerson.getName());
            System.out.println("Возраст: " + restoredPerson.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}