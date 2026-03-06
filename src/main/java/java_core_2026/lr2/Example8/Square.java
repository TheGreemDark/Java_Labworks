package java_core_2026.lr2.Example8;

public class Square extends Shape {
    private double side;
    
    public Square(String color, double side) {
        super(color);
        this.side = (side > 0) ? side : 1.0;
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
        super.printInfo();
        System.out.printf("Сторона: %.2f\n", side);
    }
}
