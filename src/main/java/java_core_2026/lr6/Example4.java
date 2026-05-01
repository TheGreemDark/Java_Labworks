package java_core_2026.lr6;

public class Example4 {
    public static void main(String[] args) {
        // Создается цикл для запуска десяти потоков
        for (int i = 1; i <= 10; i++) {
            // Запоминается текущий номер потока в final переменную 
            // для использования внутри лямбда-выражения
            final int threadNumber = i;

            // Создается новый поток
            Thread t1 = new Thread(() -> {
                // Выводим номер потока на экран
                System.out.println("Поток №" + threadNumber);
            });
            t1.start();
        }
    }
}