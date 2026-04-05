package java_core_2026.lr4;

public class Example7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e.getMessage());
            throw e;  // Переброс того же исключения
        } catch (ArithmeticException e) {
            System.out.println("2 " + e.getMessage());
        }
        System.out.println("3");
    }
}
