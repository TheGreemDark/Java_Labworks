package java_core_2026.lr2;

public class Rectangle {
    // Поля класса (private для инкапсуляции)
    private double length;
    private double width;
    
    // Конструктор с параметрами
    public Rectangle(double length, double width) {
        setLength(length);  // Используем setter для валидации
        setWidth(width);
    }
    
    // Конструктор по умолчанию
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }
    
    // Методы для установки значений (setters) с валидацией
    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            System.out.println("Ошибка: длина должна быть больше 0");
            this.length = 1.0;
        }
    }
    
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            System.out.println("Ошибка: ширина должна быть больше 0");
            this.width = 1.0;
        }
    }
    
    // Методы для получения значений (getters)
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }
    
    // Метод для вычисления площади
    public double getArea() {
        return length * width;
    }
    
    // Метод для вычисления периметра
    public double getPerimeter() {
        return 2 * (length + width);
    }
    
    // Метод для вывода информации о прямоугольнике
    public void printInfo() {
        System.out.printf("Прямоугольник: длина=%.2f, ширина=%.2f\n", length, width);
        System.out.printf("Площадь: %.2f\n", getArea());
        System.out.printf("Периметр: %.2f\n", getPerimeter());
    }
    
    // Тестовый main для проверки
    public static void main(String[] args) {
        // Создание объектов через конструктор
        Rectangle rect1 = new Rectangle(5.5, 3.2);
        System.out.println("Первый прямоугольник");
        rect1.printInfo();
        
        System.out.println("\nИзменение размеров");
        rect1.setLength(10.0);
        rect1.setWidth(-2.0);  // Тест валидации
        rect1.printInfo();
        
        System.out.println("\nВторой прямоугольник (по умолчанию)");
        Rectangle rect2 = new Rectangle();
        rect2.setLength(4.0);
        rect2.setWidth(6.0);
        rect2.printInfo();
    }
}
