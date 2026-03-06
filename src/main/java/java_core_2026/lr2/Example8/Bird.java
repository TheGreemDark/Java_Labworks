package java_core_2026.lr2.Example8;

public class Bird extends Animal {
    private boolean canFly;
    
    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " чирикает: Чи-чири!");
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Умеет летать: " + (canFly ? "Да" : "Нет"));
    }
    
    public void fly() {
        if (canFly) {
            System.out.println(name + " взлетает!");
        } else {
            System.out.println(name + " не умеет летать");
        }
    }
}