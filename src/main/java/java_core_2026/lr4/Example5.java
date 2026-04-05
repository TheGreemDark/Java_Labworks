package java_core_2026.lr4;

public class Example5 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (RuntimeException e) {
            System.out.println("1 " + e.getMessage());
        }
        System.out.println("2");
    }
}
