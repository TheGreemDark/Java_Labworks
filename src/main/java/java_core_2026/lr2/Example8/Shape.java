package java_core_2026.lr2.Example8;

public abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
    
    public void printInfo() {
        System.out.println("Фигура: " + color + " цвет");
        System.out.printf("Площадь: %.2f, Периметр: %.2f\n", getArea(), getPerimeter());
    }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
