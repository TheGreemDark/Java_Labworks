package java_core_2026.timus.lr4;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class timus_1103 {
    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Circle {
        Point center;
        double radiusSq;

        Circle(Point center, double radiusSq) {
            this.center = center;
            this.radiusSq = radiusSq;
        }
    }

    // Метод для нахождения окружности, проходящей через три точки
    // Возвращает null, если точки лежат на одной прямой
    public static Circle findCircle(Point p1, Point p2, Point p3) {
        double x1 = p1.x, y1 = p1.y;
        double x2 = p2.x, y2 = p2.y;
        double x3 = p3.x, y3 = p3.y;

        // Используем double для промежуточных вычислений для сохранения точности
        double D = 2.0 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

        // Проверка коллинеарности (если D близко к нулю)
        if (Math.abs(D) < 1e-9) {
            return null;
        }

        double centerX = ((x1 * x1 + y1 * y1) * (y2 - y3) + (x2 * x2 + y2 * y2) * (y3 - y1) + (x3 * x3 + y3 * y3) * (y1 - y2)) / D;
        double centerY = ((x1 * x1 + y1 * y1) * (x3 - x2) + (x2 * x2 + y2 * y2) * (x1 - x3) + (x3 * x3 + y3 * y3) * (x2 - x1)) / D;

        Point center = new Point(centerX, centerY);
        double radiusSq = Math.pow(x1 - centerX, 2) + Math.pow(y1 - centerY, 2);

        return new Circle(center, radiusSq);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // Гарантирует использование точки в качестве десятичного разделителя
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 3 || n > 5000 || n % 2 == 0) {
            System.out.println("No solution");
            in.close();
            return;
        }
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(in.nextDouble(), in.nextDouble()));
        }

        if (n % 2 == 0) {
            System.out.println("No solution");
            in.close();
            return;
        }

        int targetInsideCount = (n - 3) / 2;
        double epsilon = 1e-9; // Допустимая погрешность для сравнения вещественных чисел

        // Перебираем все возможные комбинации из трёх точек
        // Используем индексы для удобства вывода
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    Point p1 = points.get(i);
                    Point p2 = points.get(j);
                    Point p3 = points.get(k);

                    Circle circle = findCircle(p1, p2, p3);

                    if (circle == null) {
                        // Точки лежат на одной прямой, пропускаем эту комбинацию
                        continue;
                    }

                    int insideCount = 0;

                    // Считаем количество точек внутри окружности
                    for (int l = 0; l < n; l++) {
                        // Пропускаем три точки, которые задают окружность
                        if (l == i || l == j || l == k) {
                            continue;
                        }

                        Point currentPoint = points.get(l);
                        double distSq = Math.pow(currentPoint.x - circle.center.x, 2) +
                                        Math.pow(currentPoint.y - circle.center.y, 2);

                        if (distSq < circle.radiusSq - epsilon) {
                            insideCount++;
                        }
                    }
                    // Проверяем условие: внутри — targetInsideCount, снаружи — targetInsideCount
                    // Общее количество точек = n. На окружности = 3. Остальные = n - 3.
                    // Внутри = insideCount. Снаружи = (n - 3) - insideCount.
                    if (insideCount == targetInsideCount) {
                        if (insideCount == targetInsideCount) {
                            System.out.printf(Locale.US, "%.0f %.0f\n", p1.x, p1.y);
                            System.out.printf(Locale.US, "%.0f %.0f\n", p2.x, p2.y);
                            System.out.printf(Locale.US, "%.0f %.0f\n", p3.x, p3.y);
                            in.close();
                            return;
}

                        in.close();
                        return;
                    }
                }
            }
        }

        System.out.println("No solution");
        in.close();
    }
}
