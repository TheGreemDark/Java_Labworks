package java_core_2026.timus.lr3;

import java.util.Arrays;
import java.util.Scanner;

public class timus_1095 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int N = id.nextInt();
        System.out.print("Введите числа: ");
        if (N < 1 || N > 10000) {
            System.out.println("Error: Ограничения: N >= 1 и N <= 10000");
            id.close();
            return;
        }
        id.nextLine();

        for (int i = 0; i < N; i++) {
            String num = id.nextLine().trim();

            // Проверка длины числа (не более 20 цифр)
            if (num.length() == 0 || num.length() > 20) {
                System.out.println("0");
                continue;
            }

            // Проверяем содержит ли число все цифры 1,2,3,4
            if (!containsAllDigits(num, new char[]{'1', '2', '3', '4'})) {
                // Если не содержит, то найдем перестановку кратную 7 из цифр (по условию можно любое положительное число)
                // Но в условии задача именно о числе, в котором есть 1,2,3,4
                // Можно выводить 0, т.к. условие по задаче нам гарантирует числа с 1,2,3,4, 
                // либо можно искать просто кратное 7 перестановкой независимо.
                System.out.println("0");
                continue;
            }

            String res = findDivisiblePermutation(num);
            System.out.println(res);
        }
        id.close();
    }

    // Проверяем, содержатся ли внутри строки все указанные цифры
    private static boolean containsAllDigits(String s, char[] digits) {
        for (char d : digits) {
            if (!s.contains(String.valueOf(d))) return false;
        }
        return true;
    }

    // Поиск перестановки цифр строки num, кратной 7
    private static String findDivisiblePermutation(String num) {
        char[] digits = num.toCharArray();
        Arrays.sort(digits);  // сортируем для последовательного перебора перестановок в лексикографическом порядке

        do {
            // Проверяем, что число не начинается с '0'
            if (digits[0] == '0') continue;

            long number = 0;
            // Чтобы избежать bigint, будем считать остаток по модулю 7
            int mod = 0;
            for (char c : digits) {
                mod = (mod * 10 + (c - '0')) % 7;
            }
            if (mod == 0) {
                return new String(digits);
            }

        } while (nextPermutation(digits));

        return "0";
    }

    // Генерация следующей перестановки
    // Возвращает false, если перестановка последняя
    private static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // Перевернуть хвост
        int left = i + 1, right = arr.length - 1;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return true;
    }
}
