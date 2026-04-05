package java_core_2026.timus.lr4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class timus_1111 {
    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Вычисляет расстояние до другой точки
        double distanceTo(Point other) {
            return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        }

        // Проверяет, находится ли точка внутри прямоугольника, заданного двумя противоположными углами
        boolean isInsideRectangle(Point corner1, Point corner2) {
            double minX = Math.min(corner1.x, corner2.x);
            double maxX = Math.max(corner1.x, corner2.x);
            double minY = Math.min(corner1.y, corner2.y);
            double maxY = Math.max(corner1.y, corner2.y);
            return this.x >= minX && this.x <= maxX && this.y >= minY && this.y <= maxY;
        }
    }

    static class Square {
        int id;
        Point corner1;
        Point corner2;
        Point p;

        Square(int id, Point corner1, Point corner2, Point p) {
            this.id = id;
            this.corner1 = corner1;
            this.corner2 = corner2;
            this.p = p;
        }

        // Вычисляет минимальное расстояние от точки P до квадрата
        double getDistanceToP() {
            // Если точка P находится внутри квадрата, расстояние равно 0
            if (p.isInsideRectangle(corner1, corner2)) {
                return 0.0;
            }

            // Определяем границы прямоугольника (минимальные и максимальные координаты)
            double minX = Math.min(corner1.x, corner2.x);
            double maxX = Math.max(corner1.x, corner2.x);
            double minY = Math.min(corner1.y, corner2.y);
            double maxY = Math.max(corner1.y, corner2.y);

            // Если точка P вне прямоугольника, ближайшая точка будет на его границе
            // Ограничиваем координаты точки P пределами прямоугольника
            double closestX = Math.max(minX, Math.min(maxX, p.x));
            double closestY = Math.max(minY, Math.min(maxY, p.y));

            Point closestPointOnSquare = new Point(closestX, closestY);
            return p.distanceTo(closestPointOnSquare);
        }
    }

    // Проверяет, находится ли значение в диапазоне (-9999, 9999)
    private static boolean isValidCoordinate(int value) {
        return value > -9999 && value < 9999;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // Гарантирует использование точки в качестве десятичного разделителя
        Scanner in = new Scanner(System.in);

        // Чтение и проверка n
        if (!in.hasNextInt()) {
            System.out.println("No solution");
            in.close();
            return;
        }
        int n = in.nextInt();

        // Проверка диапазона n
        if (n < 1 || n > 50) {
            System.out.println("No solution");
            in.close();
            return;
        }

        List<Square> squares = new ArrayList<>();

        // Считываем данные о квадратах
        for (int i = 0; i < n; i++) {
            // Проверяем, что все 4 значения — целые числа
            if (!in.hasNextInt()) {
                System.out.println("No solution");
                in.close();
                return;
            }
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            // Проверка каждой координаты
            if (!isValidCoordinate(x1) || !isValidCoordinate(y1) ||
                !isValidCoordinate(x2) || !isValidCoordinate(y2)) {
                System.out.println("No solution");
                in.close();
                return;
            }

            squares.add(new Square(i + 1, new Point(x1, y1), new Point(x2, y2), null));
        }

        // Считываем координаты точки P
        if (!in.hasNextInt()) {
            System.out.println("No solution");
            in.close();
            return;
        }
        int px = in.nextInt();
        int py = in.nextInt();

        if (!isValidCoordinate(px) || !isValidCoordinate(py)) {
            System.out.println("No solution");
            in.close();
            return;
        }

        Point p = new Point(px, py);

        // Назначаем точку P каждому квадрату
        for (Square square : squares) {
            square.p = p;
        }

        // Сортируем квадраты по расстоянию до точки P
        Collections.sort(squares, new Comparator<Square>() {
            @Override
            public int compare(Square s1, Square s2) {
                double dist1 = s1.getDistanceToP();
                double dist2 = s2.getDistanceToP();
                double epsilon = 1e-14;

                if (Math.abs(dist1 - dist2) < epsilon) {
                    return Integer.compare(s1.id, s2.id);
                } else {
                    return Double.compare(dist1, dist2);
                }
            }
        });

        // Выводим ID квадратов в порядке возрастания расстояния
        for (int i = 0; i < squares.size(); i++) {
            System.out.print(squares.get(i).id + (i == squares.size() - 1 ? "" : " "));
        }
        System.out.println();

        in.close();
    }
}