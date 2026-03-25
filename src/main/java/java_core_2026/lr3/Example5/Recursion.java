package java_core_2026.lr3.Example5;

public class Recursion {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Tree(" + n + ") = " + Tree(n));
    }

    public static int Tree(int n) {
        System.out.println("Вызов Tree(" + n + ")");
        if (n == 0) {
            System.out.println("Tree(0) = 0");
            return 0;
        } else if (n == 1) {
            System.out.println("Tree(1) = 1");
            return 1;
        } else {
            int result = Tree(n - 2) + Tree(n - 1);
            System.out.println("Tree(" + n + ") = Tree(" + (n - 2) + ") + Tree(" + (n - 1) + ") = " + result);
            return result;
        }
    }
}
