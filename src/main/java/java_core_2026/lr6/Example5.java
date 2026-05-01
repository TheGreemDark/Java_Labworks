package java_core_2026.lr6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

public class Example5 {

    // Функция для поиска максимума в подмассиве
    private static class MaxFinderTask implements Callable<Integer> {
        private final int[] array;
        private final int start;
        private final int end;

        public MaxFinderTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int max = array[start];
            for (int i = start + 1; i < end; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }
    }

    public static int findMaxParallel(int[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }

        // 1. Определяем количество ядер процессора
        int numCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Используется ядер: " + numCores);

        // 2. Создаем пул потоков
        ExecutorService executor = Executors.newFixedThreadPool(numCores);
        
        int n = array.length;
        int chunkSize = (int) Math.ceil((double) n / numCores);
        
        // Список для хранения будущих результатов (Future)
        java.util.List<Future<Integer>> futures = new java.util.ArrayList<>();

        // 3. Распределяем задачи по потокам
        for (int i = 0; i < numCores; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, n);

            if (start < n) {
                futures.add(executor.submit(new MaxFinderTask(array, start, end)));
            }
        }

        // 4. Собираем результаты из всех потоков
        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            int localMax = future.get();
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        executor.shutdown();
        return globalMax;
    }

    public static void main(String[] args) {
        // Тестовый массив
        int[] data = new int[1_000_000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 10_000_000);
        }

        try {
            long startTime = System.currentTimeMillis();
            int max = findMaxParallel(data);
            long endTime = System.currentTimeMillis();

            System.out.println("Максимальный элемент: " + max);
            System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

