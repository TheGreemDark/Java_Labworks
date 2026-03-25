package java_core_2026.lr3.Example13;
import java.util.*;
public class Example13 {
    public static void main(String[] args) {
        // количество элементов в коллекции согласно варианту
        final int N = 19000000;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        SortedSet<Integer> sortedSet = new TreeSet<>();
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        // Инициализация ArrayDeque
        for (int i = 0; i < N; i++) {
            arrayDeque.addLast(i);
        }

        // Инициализация SortedSet и SortedMap
        for (int i = 0; i < N; i++) {
            sortedSet.add(i);
            sortedMap.put(i, "Value" + i);
        }

        System.out.println("ArrayDeque");
        measureArrayDeque(arrayDeque, N);

        System.out.println("\nSortedSet (TreeSet)");
        measureSortedSet(sortedSet, N);

        System.out.println("\nSortedMap (TreeMap)");
        measureSortedMap(sortedMap, N);
    }

    // Замер времени для ArrayDeque
    private static void measureArrayDeque(ArrayDeque<Integer> deque, int N) {
        // Добавление в начало
        long start = System.nanoTime();
        deque.addFirst(-1);
        long end = System.nanoTime();
        System.out.println("addFirst: " + (end - start) + " ns");

        // Добавление в конец
        start = System.nanoTime();
        deque.addLast(-2);
        end = System.nanoTime();
        System.out.println("addLast: " + (end - start) + " ns");

        // Добавление в середину
        ArrayList<Integer> tempList = new ArrayList<>(deque);
        int middleIndex = tempList.size() / 2;
        start = System.nanoTime();
        tempList.add(middleIndex, -3);
        end = System.nanoTime();
        System.out.println("add in middle (ArrayList): " + (end - start) + " ns");

        deque.clear();
        deque.addAll(tempList);

        // Удаление из начала
        start = System.nanoTime();
        deque.removeFirst();
        end = System.nanoTime();
        System.out.println("removeFirst: " + (end - start) + " ns");

        // Удаление из конца
        start = System.nanoTime();
        deque.removeLast();
        end = System.nanoTime();
        System.out.println("removeLast: " + (end - start) + " ns");

        // Удаление из середины (через List)
        tempList = new ArrayList<>(deque);
        middleIndex = tempList.size() / 2;
        start = System.nanoTime();
        tempList.remove(middleIndex);
        end = System.nanoTime();
        System.out.println("remove from middle (ArrayList): " + (end - start) + " ns");

        // Получение элемента по индексу (через List)
        int index = N / 2;
        start = System.nanoTime();
        int val = tempList.get(index);
        end = System.nanoTime();
        System.out.println("get by index (ArrayList): " + (end - start) + " ns");
    }

    // Замер времени для SortedSet
    private static void measureSortedSet(SortedSet<Integer> set, int N) {
        // Добавление (вставка упорядоченная, нет понятия начало/конец, добавление по значению)
        long start = System.nanoTime();
        set.add(-1);
        long end = System.nanoTime();
        System.out.println("add element: " + (end - start) + " ns");

        // Удаление элемента (минимального - начало)
        start = System.nanoTime();
        set.remove(set.first());
        end = System.nanoTime();
        System.out.println("remove first (min element): " + (end - start) + " ns");

        // Удаление элемента (максимального - конец)
        start = System.nanoTime();
        set.remove(set.last());
        end = System.nanoTime();
        System.out.println("remove last (max element): " + (end - start) + " ns");

        // Удаление "среднего" элемента (приближенно)
        int middle = new ArrayList<>(set).get(set.size() / 2);
        start = System.nanoTime();
        set.remove(middle);
        end = System.nanoTime();
        System.out.println("remove middle element: " + (end - start) + " ns");

        // Получение элемента по индексу (через конвертацию)
        int index = N / 2;
        ArrayList<Integer> tempList = new ArrayList<>(set);
        start = System.nanoTime();
        int val = tempList.get(index);
        end = System.nanoTime();
        System.out.println("get by index: " + (end - start) + " ns");
    }

    // Замер времени для SortedMap
    private static void measureSortedMap(SortedMap<Integer, String> map, int N) {
        // Добавление элемента (ключ-значение)
        long start = System.nanoTime();
        map.put(-1, "newValue");
        long end = System.nanoTime();
        System.out.println("put element: " + (end - start) + " ns");

        // Удаление первого (минимального) элемента
        start = System.nanoTime();
        map.remove(map.firstKey());
        end = System.nanoTime();
        System.out.println("remove first key: " + (end - start) + " ns");

        // Удаление последнего (максимального) элемента
        start = System.nanoTime();
        map.remove(map.lastKey());
        end = System.nanoTime();
        System.out.println("remove last key: " + (end - start) + " ns");

        // Удаление "среднего" элемента
        int middleKey = new ArrayList<>(map.keySet()).get(map.size() / 2);
        start = System.nanoTime();
        map.remove(middleKey);
        end = System.nanoTime();
        System.out.println("remove middle key: " + (end - start) + " ns");

        // Получение по ключу
        int index = N / 2;
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        int keyAtIndex = keys.get(index);
        start = System.nanoTime();
        String val = map.get(keyAtIndex);
        end = System.nanoTime();
        System.out.println("get by key (list key at index): " + (end - start) + " ns");
    }
}