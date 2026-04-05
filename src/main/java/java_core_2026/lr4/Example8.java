package java_core_2026.lr4;

public class Example8 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            m();
        } catch (RuntimeException e) {
            // Исключение перехвачено из метода m()
        }
        System.out.println("End of main");
    }
    
    public static void m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } finally {
            System.out.println("1");
        }
    }
}
