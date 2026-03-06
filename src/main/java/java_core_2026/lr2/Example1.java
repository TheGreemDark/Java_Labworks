package java_core_2026.lr2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example1 {
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
        // Сортировка массива по возрастанию его элементов
        Arrays.sort(nums);
        // Сообщение пользователю "для красоты и понимания"
        System.out.println("Произведена сортировка массива");
        for (int i = 0 ; i < nums.length ; i++){
            // Сообщение пользователю "для красоты и понимания"
            System.out.println("Элемент массива ["+i+"] после сортировки = " + nums[i]);
        }
        id.close();
    }
}