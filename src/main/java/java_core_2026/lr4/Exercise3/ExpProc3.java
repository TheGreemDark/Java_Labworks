package java_core_2026.lr4.Exercise3;
import java.util.Scanner;
import java.util.InputMismatchException;
public class ExpProc3 {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        byte[] array = null;
        
        try {
            System.out.println("Сумма элементов массива byte");
            array = readByteArray();
            
            long sum = calculateSum(array);
            System.out.println("Сумма элементов: " + sum);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Введена строка или число вне диапазона byte (-128..127) [InputMismatchException]");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + " [IllegalArgumentException]");
        } catch (Exception e) {
            System.out.println("Error: Неожиданная ошибка: " + e.getMessage());
        } finally {
            System.out.println("Finally: Завершение программы");
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    
    private static byte[] readByteArray() {
        System.out.print("Размер массива: ");
        int size = scanner.nextInt();
        
        if (size <= 0) {
            throw new IllegalArgumentException("Размер должен быть > 0");
        }
        
        byte[] array = new byte[size];
        System.out.println("Введите " + size + " чисел типа byte (-128..127):");
        
        for (int i = 0; i < size; i++) {
            try {
                array[i] = scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Элемент " + (i+1) + ": неверный формат или вне диапазона");
                scanner.next(); // очистка буфера
                i--; // повторный ввод
            }
        }
        return array;
    }
    
    private static long calculateSum(byte[] array) {
        long sum = 0;
        for (byte b : array) {
            sum += b;
        }
        return sum;
    }
}