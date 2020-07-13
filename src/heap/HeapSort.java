package heap;


import algorithm_4.section_2.SortCompare;

import java.util.Arrays;

public class HeapSort {

    /**
     * 通过自下往上插入的方式构建一个大顶堆
     */
    private static void buildHeap(Double[] a, int n) {
        // 从数组第二个位置开始插入，循环执行完后数据也就插入完毕
        for (int i = 2; i < n; i++) {
            insert(a, a[i], i);
        }
    }

    /**
     * 通过自上往下的方式构建一个大顶堆
     *
     * @param a
     */
    private static void buildHeap(Double[] a) {
        for (int i = a.length / 2; i >= 1; --i) {
            heapify(a, i);
        }
    }

    private static void heapify(Double[] a, int i) {
        while (true) {
            int maxp = i;
            if (i * 2 < a.length && a[i] < a[i * 2]) maxp = i * 2;
            if (i * 2 + 1 < a.length && a[maxp] < a[i * 2 + 1]) maxp = i * 2 + 1;
            if (maxp == i) break;
            exch(a, i, maxp);
            i = maxp;
        }
    }


    private static void sort(Double[] a, int n) {
        int k = n - 1;
        while (k > 1) {
            exch(a, 1, k);
            k--;
            heapify(a, k);
        }
    }

    private static void insert(Double[] a, Double data, int i) {
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            exch(a, i, i / 2);
            i = i / 2;
        }
    }

    public static void heapSort(Double[] a) {
        buildHeap(a);
        sort(a, a.length);
    }

    private static void exch(Double[] a, int i, int j) {
        Double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Double[] array = SortCompare.Companion.uniformArray(101);
        array[0] = 0d;
        for (Double value : array) {
            System.out.print(value + " ");
        }
        heapSort(array);
        System.out.println();
        for (Double aDouble : array) {
            System.out.print(aDouble + " ");
        }
    }
}
