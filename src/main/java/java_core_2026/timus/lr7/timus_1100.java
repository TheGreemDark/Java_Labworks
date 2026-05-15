package java_core_2026.timus.lr7;

import java.util.*;
import java.io.*;

public class timus_1100 {
    static class Command {
        int id;
        int m;
        Command(int id, int m) {
            this.id = id;
            this.m = m;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Command[] commands = new Command[n];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int m = sc.nextInt();
            commands[i] = new Command(id, m);
        }
        Arrays.sort(commands, (a, b) -> Integer.compare(b.m, a.m));
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) {
            out.println(commands[i].id + " " + commands[i].m);
        }
        out.flush();
        out.close();
    }
}
