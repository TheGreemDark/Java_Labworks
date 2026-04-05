package java_core_2026.lr4;

public class Example1 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
        } catch (RuntimeException e) {
            // Исключение перехвачено и обработано
            System.out.println("1 " + e.getMessage());
        }
        System.out.println("2"); // код продолжает выполнение
    }
}
