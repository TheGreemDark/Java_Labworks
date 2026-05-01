package java_core_2026.lr6;

public class Example3 {
    private static final Object lock = new Object();
    private static int number = 1; // Общий счетчик

    public static void main(String[] args) {
        
        Thread evenThread = new Thread(() -> {
            while (number < 10) {
                synchronized (lock) {
                    while (number % 2 != 0 && number <= 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                    if (number < 10) {
                        System.out.println("Even Thread: " + number);
                        number++;
                        lock.notifyAll();
                    }
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            while (number < 10) {
                synchronized (lock) {
                    while (number % 2 == 0 && number < 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (number <= 10) {
                        System.out.println("Odd Thread: " + number);
                        number++;
                        lock.notifyAll();
                    }
                }
            }
        });

        evenThread.setName("Even Thread");
        oddThread.setName("Odd Thread");

        oddThread.start();
        evenThread.start();
    }
}

