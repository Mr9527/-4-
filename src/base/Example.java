package base;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class Example {

    public static void sort(Comparable[] array) {

    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] comparables) {
        for (Comparable comparable : comparables) {
            StdOut.print(comparable);
            StdOut.println();
        }
    }

    public static boolean isSorted(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            if (less(comparables[i], comparables[i - 1])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] strings = In.readStrings();
        sort(strings);
        assert isSorted(strings);
        show(strings);
    }
}

