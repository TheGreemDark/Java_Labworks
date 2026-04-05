package java_core_2026.lr4;

public class Example9 {
    public static int m() {
        try {
            System.out.println("0");
            return 55;  // return помещается в стек
        } finally {
            System.out.println("1");  // finally выполняется всегда
        }
        // return 55 возвращается после finally
    }

    public static void main(String[] args) {
        System.out.println(m());  // Выводит 55
    }
}