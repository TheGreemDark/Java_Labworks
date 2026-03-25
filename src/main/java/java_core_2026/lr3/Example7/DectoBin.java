package java_core_2026.lr3.Example7;
import java.util.Scanner;

public class DectoBin {
    // Рекурсивный метод перевода в двоичный вид
    public static String toBinary(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        // Рекурсивный вызов с делением на 2 + остаток
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = in.nextInt();
        
        // Обработка отрицательных чисел
        if (number < 0) {
            System.out.print("Отрицательное число: -");
            System.out.println(toBinary(-number));
        } else {
            System.out.println(toBinary(number));
        }
        in.close();
    }
}