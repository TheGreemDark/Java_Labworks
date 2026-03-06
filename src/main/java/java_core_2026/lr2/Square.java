package java_core_2026.lr2;

public class Square implements Shape {
    private double side;
    
    public Square(double side) {
        if (side > 0) {
            this.side = side;
        } else {
            this.side = 1.0;
        }
    }
    
    @Override
    public double getArea() {
        return side * side;
    }
    
    @Override
    public double getPerimeter() {
        return 4 * side;
    }
    
    @Override
    public void printInfo() {
        System.out.printf("Квадрат: сторона=%.2f, Площадь=%.2f, Периметр=%.2f\n", 
                         side, getArea(), getPerimeter());
    }
    
    public double getSide() {
        return side;
    }
}
