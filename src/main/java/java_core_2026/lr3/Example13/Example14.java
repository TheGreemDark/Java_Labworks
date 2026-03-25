package java_core_2026.lr3.Example13;

import java.util.ArrayDeque;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Example14 {
    public static void main(String[] args) {
        // количество элементов в коллекции
        final long N = 19000000000L;

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        SortedSet<Integer> sortedSet = new TreeSet<>();
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        // Инициализация ArrayDeque
        for (long i = 0; i < N; i++) {
            arrayDeque.addLast((int) (i % Integer.MAX_VALUE));
        }

        // Инициализация SortedSet и SortedMap
        for (long i = 0; i < N; i++) {
            int key = (int) (i % Integer.MAX_VALUE);
            sortedSet.add(key);
            sortedMap.put(key, "Value" + key);
        }

        System.out.println("ArrayDeque");
        measureArrayDeque(arrayDeque, N);

        System.out.println("\nSortedSet (TreeSet)");
        measureSortedSet(sortedSet, N);

        System.out.println("\nSortedMap (TreeMap)");
        measureSortedMap(sortedMap, N);
    }

    static void measureArrayDeque(ArrayDeque<Integer> deque, long N) {
        long start = System.nanoTime();
        for (long i = 0; i < N; i++) {
            deque.getFirst(); // пример получения по элементу (getFirst(), т.к. индекс по ArrayDeque напрямую нельзя)
        }
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000 + " ms");
    }

    static void measureSortedSet(SortedSet<Integer> set, long N) {
        long start = System.nanoTime();
        for (long i = 0; i < N; i++) {
            set.contains((int) (i % Integer.MAX_VALUE));
        }
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000 + " ms");
    }

    static void measureSortedMap(SortedMap<Integer, String> map, long N) {
        long start = System.nanoTime();
        for (long i = 0; i < N; i++) {
            map.get((int) (i % Integer.MAX_VALUE));
        }
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000 + " ms");
    }
}
