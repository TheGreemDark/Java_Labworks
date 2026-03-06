package java_core_2026.lr2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Example1_with_minValue {
    public static void main(String[] args) {
        // Создание объекта класса Scanner для считывания числа введённого к консоль
        Scanner id = new Scanner(System.in);
        // Сообщение пользователю "для красоты и понимания"
        System.out.println("Введите размер массива");
        // Запись в переменную Size (нужная для того чтобы задать размер массива)
        int size = id.nextInt();
        // Значения введённого в консоль
        System.out.println("Размер массива равен "+ size);
        // Создание массива с размером введённым из консоли
        int[] nums = new int[size];
        // Создание объекта класса Random для генерации "случайного" числа
        Random random = new Random();

        for (int i = 0; i < nums.length ; i++){
            // Присвоение i-тому элементу массива случайного значения
            nums[i] = random.nextInt(200);
            // Сообщение пользователю "для красоты и понимания"
            System.out.println("Элемент массива ["+i+"] = " + nums[i]);
        }
        // Поиск минимального значения и всех индексов
        int minValue = nums[0];
        List<Integer> minIndices = new ArrayList<>();
        minIndices.add(0); // Первый индекс
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
                minIndices.clear();
                minIndices.add(i);
            } else if (nums[i] == minValue) {
                minIndices.add(i);
            }
        }
        
        // Вывод результатов
        System.out.println("Массив: " + Arrays.toString(nums));
        System.out.println("Минимальное значение: " + minValue);
        System.out.print("Индексы минимального элемента: ");
        for (int idx : minIndices) {
            System.out.print(idx + " ");
        }
        System.out.println();
        
        id.close();
    }
}
