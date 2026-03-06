package java_core_2026.lr2.Example8;

public class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = (radius > 0) ? radius : 1.0;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Радиус: %.2f\n", radius);
    }
}
