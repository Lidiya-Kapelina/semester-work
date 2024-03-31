import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TopSort {//код со счетчиками
    static ArrayList<ArrayList<Integer>> g;
    static ArrayList<Integer> top = new ArrayList<Integer>();
    static int used[];
    static int n, m, flag = 0;

    static int dfs(int v) {
        used[v] = 1;
        int m = 0;
        m += 1;
        for (int i = 0; i < g.get(v).size(); i++) {
            int to = g.get(v).get(i);
            m += 9;
            if (used[to] == 1) {
                flag = 1;
                m += 1;
            }
            if (used[to] == 0) {
                m += 1 + dfs(to);
            }
        }
        used[v] = 2;
        m += 1;
        top.add(v);
        m += 1;
        return m;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Data.txt"));
        for (int i1 = 0; i1 < 100; i1 += 1) {


            n = sc.nextInt();
            m = sc.nextInt();
            g = new ArrayList<>();
            used = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                g.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                g.get(a).add(b);
            }
            int k = 0;
            double t1 = System.nanoTime();
            for (int i = 1; i <= n; i++) {
                k += 4;
                if (used[i] == 0) {
                    k += 1 + dfs(i);
                }
            }
                System.out.print(System.nanoTime() - t1 + " ");
                System.out.print(m * 2 + 2 + " ");
                System.out.println(k);

        }
    }
}
