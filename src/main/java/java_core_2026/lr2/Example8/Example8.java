package java_core_2026.lr2.Example8;

public class Example8 {
     public static void main(String[] args) {
        System.out.println("Наследование - животные\n");
        
        // Тестирование животных
        Dog dog = new Dog("Рекс", 3, "Овчарка");
        Cat cat = new Cat("Мишка", 2, "Вискас");
        Bird bird = new Bird("Кеша", 1, true);
        
        Animal[] animals = {dog, cat, bird};
        for (Animal animal : animals) {
            animal.printInfo();
            animal.makeSound();
            System.out.println();
            
            // Вызов уникальных методов
            if (animal instanceof Dog) ((Dog) animal).fetchBall();
            else if (animal instanceof Cat) ((Cat) animal).climbTree();
            else if (animal instanceof Bird) ((Bird) animal).fly();
            System.out.println("   \n");
        }
        
        System.out.println("Наследование - фигуры\n");
        
        // Тестирование фигур
        Circle circle = new Circle("Красный", 5.0);
        Square square = new Square("Синий", 4.0);
        Triangle triangle = new Triangle("Зеленый", 3.0, 4.0, 5.0);
        
        Shape[] shapes = {circle, square, triangle};
        double totalArea = 0;
        for (Shape shape : shapes) {
            shape.printInfo();
            totalArea += shape.getArea();
            System.out.println();
        }
        
        System.out.printf("Общая площадь фигур: %.2f\n", totalArea);
    }
}
