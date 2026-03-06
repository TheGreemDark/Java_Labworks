package java_core_2026.lr2.Example8;

public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " лает: Гав-гав!");
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Порода: " + breed);
    }
    
    public void fetchBall() {
        System.out.println(name + " приносит мячик!");
    }
}
