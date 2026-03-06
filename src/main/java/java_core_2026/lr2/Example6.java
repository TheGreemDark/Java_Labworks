package java_core_2026.lr2;

public class Example6 {
    public static void main(String[] args) {
        // Создание массива фигур
        Shape[] shapes = {
            new Circle(5.0),
            new Square(5.0),
            new Triangle(3.0, 4.0, 5.0)
        };
        
        System.out.println("Информация о фигурах\n");
        
        for (Shape shape : shapes) {
            shape.printInfo();
            System.out.println();
        }
        
        // Подсчет общей площади и периметра
        double totalArea = 0, totalPerimeter = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
            totalPerimeter += shape.getPerimeter();
        }
        
        System.out.printf("Общая площадь всех фигур: %.2f\n", totalArea);
        System.out.printf("Общий периметр всех фигур: %.2f\n", totalPerimeter);
    }
}
