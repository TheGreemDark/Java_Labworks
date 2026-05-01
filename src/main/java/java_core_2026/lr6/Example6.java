package java_core_2026.lr6;

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class Example6 {
    // Задача для каждого потока
    private static class SumTask implements Callable<Long> {
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() {
            long partialSum = 0;
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
            return partialSum;
        }
    }

    public static long findSumParallel(int[] array) throws Exception {
        if (array == null || array.length == 0) {
            return 0;
        }

        // 1. Определяем количество ядер
        int numCores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numCores);
        
        int n = array.length;
        // Вычисляется размер чанка так, чтобы покрыть весь массив
        int chunkSize = (int) Math.ceil((double) n / numCores);
        List<Future<Long>> futures = new ArrayList<>();

        // 2. Распределяется работа по потокам и запускается задача
        for (int i = 0; i < numCores; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, n);

            if (start < n) {
                futures.add(executor.submit(new SumTask(array, start, end)));
            }
        }

        // 3. Агрегируются результаты
        long totalSum = 0;
        for (Future<Long> future : futures) {
            // get() блокирует выполнение до завершения задачи
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
    }

    public static void main(String[] args) {
        // Тестовый массив с большим количеством элементов
        int[] data = new int[10_000_000];
        for (int i = 0; i < data.length; i++) {
            data[i] = 1;
        }

        try {
            long startTime = System.nanoTime();
            long sum = findSumParallel(data);
            long endTime = System.nanoTime();

            System.out.println("Сумма элементов: " + sum);
            System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000.0 + " мс");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

