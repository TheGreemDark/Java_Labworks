package java_core_2026.lr4;

public class Example4 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e.getMessage());
        } catch (Exception e) {
            System.out.println("2 " + e.getMessage());
        } catch (Error e) {
            System.out.println("3 " + e.getMessage());
        }
        System.out.println("4");
    }
}
