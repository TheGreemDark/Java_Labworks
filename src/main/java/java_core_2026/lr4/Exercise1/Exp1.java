package java_core_2026.lr4.Exercise1;
import java.util.Scanner;
public class Exp1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Введите размер массива: ");
        int size = in.nextInt();
        int[] array = new int[size];
        
        System.out.println("Введите " + size + " чисел:");
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        
        double average = calculateAverage(array);
        System.out.println("Среднее положительных: " + average);
        in.close();
    }
    
    private static double calculateAverage(int[] array) {
        int sum = 0, count = 0;
        for (int num : array) {
            if (num > 0) {
                sum += num;
                count++;
            }
        }
        return sum / (double) count;
    }
}
