package a1;

import java.util.*;
import java.io.*;

public class TopSort1 {//код без счетчиков
    static ArrayList<ArrayList<Integer>> g;
    static ArrayList<Integer> top = new ArrayList<>();
    static int used[];
    static int n, m, flag = 0;

    static void dfs(int v) {
        used[v] = 1;
        for (int i = 0; i < g.get(v).size(); i++) {
            int to = g.get(v).get(i);
            if (used[to] == 1) flag = 1;
            if (used[to] == 0) dfs(to);
        }
        used[v] = 2;
        top.add(v);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Data.txt"));

        n = sc.nextInt();
        m = sc.nextInt();
        g = new ArrayList<>();
        used = new int[n + 1];

        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g.get(a).add(b);
        }
        for (int i = 1; i <= n; i++)
            if (used[i] == 0) dfs(i);

        if (flag == 1) System.out.println("-1");
        else
            for (int i = top.size() - 1; i >= 0; i--)
                System.out.print(top.get(i) + " ");
    }
}
