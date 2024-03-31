package a1;

import java.io.*;
import java.util.Random;
import java.io.FileWriter;

public class Gener {//генерирует много графов с циклами

    public static void main(String[] args) {
        Random random = new Random();
        try (FileWriter in = new FileWriter("./src/Data.txt")) {
            for (int i = 0; i < 100; i += 1) {
                int nv = random.nextInt(4000) + 100;
                int nr = random.nextInt(4000) + 100;
                int n1;
                int n2;
                in.write(Integer.toString(nv) + " ");
                in.write(Integer.toString(nr) + " ");

                for (int i1 = 0; i1 < nr; i1 += 1) {
                    n1 = random.nextInt(nv + 1);
                    n2 = random.nextInt(nv + 1);
                    in.write(Integer.toString(n1) + " ");
                    in.write(Integer.toString(n2) + " ");

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
