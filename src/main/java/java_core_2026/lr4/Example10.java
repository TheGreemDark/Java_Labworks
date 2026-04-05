package java_core_2026.lr4;

public class Example10 {
    public static int m() {
        int result = 0;
        try {
            System.out.println("0");
            result = 15;
        } finally {
            System.out.println("1");
            result = 20;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}