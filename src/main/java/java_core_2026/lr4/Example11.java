package java_core_2026.lr4;

public class Example11 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e.getMessage());
        } finally {
            System.out.println("2");
        }
        System.out.println("3");
    }
}