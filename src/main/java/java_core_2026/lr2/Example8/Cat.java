package java_core_2026.lr2.Example8;

public class Cat extends Animal {
    private String foodType;
    
    public Cat(String name, int age, String foodType) {
        super(name, age);
        this.foodType = foodType;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " мяукает: Мяу-мяу!");
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Любимая еда: " + foodType);
    }
    
    public void climbTree() {
        System.out.println(name + " лазает по деревьям!");
    }
}
