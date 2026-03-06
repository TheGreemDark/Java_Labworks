package java_core_2026.lr2;

public class Person {
    // Поля класса (private для инкапсуляции)
    private String name;
    private int age;
    private String gender;
    
    // Конструктор с параметрами
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    // Конструктор по умолчанию
    public Person() {
        this.name = "Неизвестно";
        this.age = 0;
        this.gender = "Не указан";
    }
    
    // Методы для установки значений (setters)
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    // Методы для получения значений (getters)
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getGender() {
        return gender;
    }
    
    // Метод для вывода информации о человеке
    public void printInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Пол: " + gender);
    }
    
    // main для проверки
    public static void main(String[] args) {
        // Создание объекта через конструктор
        Person person1 = new Person("Алекс Смирнов", 25, "мужской");
        person1.printInfo();
        
        System.out.println("\nИзменение данных");
        person1.setAge(26);
        person1.setGender("Мужской");
        person1.printInfo();
        
        // Создание через конструктор по умолчанию
        Person person2 = new Person();
        person2.setName("Игнация Грульгор");
        person2.setAge(30);
        person2.setGender("женский");
        System.out.println("\nВторой человек");
        person2.printInfo();
    }
}
