package java_core_2026.lr4.Exercise1;
import java.util.Scanner;
import java.util.InputMismatchException;
public class ExpProc1 {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[] array = null;
        try {
            System.out.println("Вычисление среднего положительных элементов");
            array = readArray();
            
            double avg = calculateAverage(array);
            System.out.printf("Result: Среднее = %.2f%n", avg);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Введена строка вместо числа");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finally: Завершение программы");
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    
    private static int[] readArray() {
        System.out.print("Размер массива: ");
        int size = scanner.nextInt();
        if (size <= 0) {
            throw new IllegalArgumentException("Размер должен быть > 0");
        }
        
        int[] array = new int[size];
        System.out.println("Введите " + size + " чисел:");
        
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
    
    private static double calculateAverage(int[] array) {
        int sum = 0, count = 0;
        for (int num : array) {
            if (num > 0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) {
            throw new ArithmeticException("Положительные элементы отсутствуют");
        }
        return sum / (double) count;
    }
}