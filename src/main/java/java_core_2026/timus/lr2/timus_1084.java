package java_core_2026.timus.lr2;

import java.util.Scanner;

public class timus_1084 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Введите величину длины стороны огорода и длины верёвки в метрах, положительные числа не превосходящие 100");
        int side = in.nextInt();
        int rope = in.nextInt();
        
        if (side < 1 || side > 100 || rope < 1 || rope > 100) {
            System.out.println("Числа должны быть положительными и не превосходящими 100");
            in.close();
            return;
        }
        
        double area = calculateGoatArea(side, rope);
        System.out.printf("%.3f\n", area);
        
        in.close();
    }
    
    public static double calculateGoatArea(int side, int rope) {
        double R = side / 2.0;  // до края
        double L = rope;        // длина веревки
        
        // Случай 1: веревка не достает до края
        if (L <= R) {
            return Math.PI * L * L;
        }
        
        // Случай 2: достает до углов
        if (L >= R * Math.sqrt(2)) {
            return (double) side * side;
        }
        
        // Случай 3: основной - сектор минус треугольник
        if (R < 2 * L) {
            double a = Math.acos(R * 2 / (2.0 * L));
            double s = Math.PI * L * L - (4 * (a * L * L - 0.5 * L * L * Math.sin(2 * a)));
            return s;
        }

        return Math.PI * L * L;
    }
}
