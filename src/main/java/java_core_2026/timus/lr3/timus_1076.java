package java_core_2026.timus.lr3;

import java.util.Arrays;
import java.util.Scanner;

public class timus_1076 {
    static int N;
    static int[][] amount;
    static int INF = 1000000000;

    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        N = id.nextInt();
        if (N > 150 || N < 1) {
            System.out.println("Error: Ограничения: N >= 1 и N <= 150");
            id.close();
            return;
        }
        System.out.print("Заполнение матрицы: ");
        amount = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                int val = id.nextInt();
                if (val < 0 || val > 100) {
                    System.out.println("Количество мусора должно быть в пределах 0 ≤ amount ≤ 100");
                    id.close();
                    return;
                }
                amount[i][j] = val;
            }
        }    
            

        int[][] cost = new int[N][N];

        // Построение матрицы затрат
        // cost[i][j] - сколько придется потратить, если контейнер j будет содержать мусор типа i
        // Затраты = суммируем по всем исходным контейнерам i всякий раз, когда i != j:
        // количество мусора типа i в контейнере idx, если idx != j
        for (int type = 0; type < N; type++) {
            for (int containerForType = 0; containerForType < N; containerForType++) {
                int sum = 0;
                for (int originalContainer = 0; originalContainer < N; originalContainer++) {
                    if (originalContainer != containerForType)
                        sum += amount[originalContainer][type]; // мусор типа i надо перегрузить
                }
                cost[type][containerForType] = sum;
            }
        }

        // Решаем задачу присваивания cost[][] с помощью алгоритма Венгера
        int result = hungarian(cost);
        System.out.print("Минимальное количество усилий, необходимых для сортировки мусора: ");
        System.out.println(result);
    id.close();
    }
    

    // Алгоритм Венгера - решение задачи найма
    static int hungarian(int[][] cost) {
        int n = cost.length;
        int[] u = new int[n+1];
        int[] v = new int[n+1];
        int[] p = new int[n+1];
        int[] way = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            p[0] = i;
            int j0 = 0;
            int[] minv = new int[n+1];
            boolean[] used = new boolean[n+1];
            Arrays.fill(minv, INF);
            do {
                used[j0] = true;
                int i0 = p[j0], j1 = 0;
                int delta = INF;
                for (int j = 1; j <= n; ++j) {
                    if (!used[j]) {
                        int cur = cost[i0-1][j-1] - u[i0] - v[j];
                        if (cur < minv[j]) {
                            minv[j] = cur;
                            way[j] = j0;
                        }
                        if (minv[j] < delta) {
                            delta = minv[j];
                            j1 = j;
                        }
                    }
                }
                for (int j = 0; j <= n; ++j) {
                    if (used[j]) {
                        u[p[j]] += delta;
                        v[j] -= delta;
                    } else {
                        minv[j] -= delta;
                    }
                }
                j0 = j1;
            } while (p[j0] != 0);
            do {
                int j1 = way[j0];
                p[j0] = p[j1];
                j0 = j1;
            } while (j0 != 0);
        }
        int answer = 0;
        for (int j = 1; j <= n; ++j)
            answer += cost[p[j]-1][j-1];
        return answer;
    }
}
