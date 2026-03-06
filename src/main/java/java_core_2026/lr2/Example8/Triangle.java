package java_core_2026.lr2.Example8;

public class Triangle extends Shape {
    private double sideA, sideB, sideC;
    
    public Triangle(String color, double sideA, double sideB, double sideC) {
        super(color);
        this.sideA = (sideA > 0) ? sideA : 1.0;
        this.sideB = (sideB > 0) ? sideB : 1.0;
        this.sideC = (sideC > 0) ? sideC : 1.0;
    }
    
    @Override
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Стороны: %.2f, %.2f, %.2f\n", sideA, sideB, sideC);
    }
}
