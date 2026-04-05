package java_core_2026.lr4.Exercise3;
import java.util.Scanner;
public class Exp3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Размер массива: ");
        int size = in.nextInt();
        byte[] array = new byte[size];
        
        System.out.println("Введите " + size + " чисел типа byte (-128..127):");
        for (int i = 0; i < size; i++) {
            array[i] = in.nextByte();
        }
        
        long sum = 0;
        for (byte b : array) {
            sum += b;
        }
        System.out.println("Сумма: " + sum);
        in.close();
    }
}