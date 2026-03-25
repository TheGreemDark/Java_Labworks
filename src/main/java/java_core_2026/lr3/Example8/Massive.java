package java_core_2026.lr3.Example8;

import java.util.Scanner;

public class Massive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = in.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        inputArray(array, 0, in);

        System.out.println("Введённый массив:");
        outputArray(array, 0);
    }

    // Рекурсивный ввод элементов массива
    public static void inputArray(int[] arr, int index, Scanner in) {
        if (index == arr.length) return;
        arr[index] = in.nextInt();
        inputArray(arr, index + 1, in);
    }

    // Рекурсивный вывод элементов массива
    public static void outputArray(int[] arr, int index) {
        if (index == arr.length) return;
        System.out.print(arr[index] + " ");
        outputArray(arr, index + 1);
    }
}
