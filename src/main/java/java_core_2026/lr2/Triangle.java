package java_core_2026.lr2;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    
    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA > 0 && sideB > 0 && sideC > 0) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        } else {
            this.sideA = this.sideB = this.sideC = 1.0;
        }
    }
    
    @Override
    public double getArea() {
        // Формула Герона
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    
    @Override
    public void printInfo() {
        System.out.printf("Треугольник: %.2f/%.2f/%.2f, Площадь=%.2f, Периметр=%.2f\n", 
                         sideA, sideB, sideC, getArea(), getPerimeter());
    }
}