package java_core_2026.lr2;

public class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1.0;
        }
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
        System.out.printf("Круг: r=%.2f, Площадь=%.2f, Периметр=%.2f\n", 
                         radius, getArea(), getPerimeter());
    }
    
    public double getRadius() {
        return radius;
    }
}
