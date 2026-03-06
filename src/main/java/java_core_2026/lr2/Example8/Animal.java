package java_core_2026.lr2.Example8;

public class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void makeSound() {
        System.out.println(name + " издает звук");
    }
    
    public void printInfo() {
        System.out.println("Животное: " + name + ", Возраст: " + age);
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
