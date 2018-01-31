package section_2;

import base.Example;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

import java.util.Random;

public class Selection {

    public static void sort(Double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (Example.less(a[j], a[min])) {
                    min = j;
                }
                double y = a[j] / 2;
                StdDraw.filledRectangle(1.0 * j / N, y, 0.5 / N, y);
            }
            Example.exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Double[] comparables = new Double[10];
        for (int i = 0; i < 10; i++) {
            comparables[i] = StdRandom.uniform();
        }
        for (Comparable comparable : comparables) {
            StdOut.print(comparable + " ");
        }
        StdOut.println();
        sort(comparables);
        for (Comparable comparable : comparables) {
            StdOut.print(comparable + " ");
        }
        StdOut.println();

        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.random();
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
