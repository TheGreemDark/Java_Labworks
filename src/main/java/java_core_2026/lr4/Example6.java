package java_core_2026.lr4;

public class Example6 {
   public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (RuntimeException e) {
            System.out.println("1 " + e.getMessage());
        } catch (Exception e) {
            System.out.println("2 " + e.getMessage());
        }
        System.out.println("4");
    }
}
