package algorithm_4.section_2;

import edu.princeton.cs.introcs.StdRandom;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class JavaSortImplement {

    /**
     * 冒泡排序
     *
     * @param array
     */
    static void bubbleSort(int[] array) {
        boolean flag;
        for (int i = 0; i < array.length; ++i) {
            flag = false;
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }

    static int[] createArray() {
        int[] array = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            array[i] = StdRandom.uniform(100);
        }
        return array;
    }

    static void printArray(int[] array) {
        System.out.println("");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }

    static void mergeSort(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int[] tmpArray = new int[array.length];
        mergeSort(array, tmpArray, start, end);
    }

    static void mergeSort(int[] array, int[] tmpArray, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(array, tmpArray, start, mid);
        mergeSort(array, tmpArray, mid + 1, end);
        mergeSort(array, tmpArray, start, mid, end);
    }

    static void mergeSort(int[] array, int[] tmpArray, int start, int mid, int end) {
        int k = 0;
        int i = start;
        int j = mid + 1;
        //将数组中较小的数据放到临时数组中，直到有一个数组放置完。
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                tmpArray[k++] = array[i++];
            } else {
                tmpArray[k++] = array[j++];
            }
        }
        // 将还未防止完的数组塞入到临时数组的尾部
        int s = start, e = mid;
        if (j <= end) {
            s = j;
            e = end;
        }
        while (s <= e) {
            tmpArray[k++] = array[s++];
        }
        //将整理好的数据放置到原数组对应的位置
        for (int l = 0; l <= end - start; l++) {
            array[start + l] = tmpArray[l];
        }
    }

    static void mergeSortByFor(int[] array) {
        int[] tmpArray = new int[array.length];
        for (int sz = 1; sz < array.length; sz = sz + sz) {
            for (int lo = 0; lo < array.length - sz; lo += sz + sz) {
                mergeSortByFor(array, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, array.length - 1), tmpArray);
            }
        }
    }

    static void mergeSortByFor(int[] a, int lo, int mid, int hi, int[] t) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            t[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = t[j++];
            else if (j > hi) a[k] = t[i++];
            else if (t[j] < t[i]) a[k] = t[j++];
            else a[k] = t[i++];
        }
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k];
    }

    public static void quickSort(int[] nums, int lo, int hi) {
        if (hi <= lo) return;
        int j = partitionA(nums, lo, hi);
        quickSort(nums, lo, j - 1);
        quickSort(nums, j + 1, hi);
    }

    public static int search(int[] array, int k) {
        int lo = 0;
        int hi = array.length - 1;
        int count = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] == k) {
                count = 1;
                lo = mid - 1;
                hi = mid + 1;
                while ((lo >= 0 && array[lo] == k) || (hi < array.length && array[hi] == k)) {
                    if (lo >= 0 && array[lo] == k) {
                        lo--;
                        count++;
                    }
                    if (hi < array.length && array[hi] == k) {
                        hi++;
                        count++;
                    }

                }
                return count;
            }
            if (k < array[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return count;
    }
//    public static int findElement(int[] array, int k) {
//        int lo = 0;
//        int hi = array.length - 1;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (array[mid] == k) {
//                return mid;
//            }
//            if (k < array[mid]) {
//                hi = mid - 1;
//            } else {
//                lo = mid +1;
//            }
//        }
//        return -1;
//    }
//
//    public static int findElement(int[] array, int k) {
//        return findElement(array, k, 0, array.length - 1);
//    }
//
//    public static int findElement(int[] array, int k, int lo, int hi) {
//        if (hi < lo) {
//            return -1;
//        }
//        int mid = lo + (hi - lo) / 2;
//        if (k == array[mid]) {
//            return mid;
//        }
//        if (k < array[mid]) {
//            hi = mid - 1;
//        } else {
//            lo = mid + 1;
//        }
//        return findElement(array, k, lo, hi);
//    }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int pivot = a[lo];
        while (true) {
            while (a[++i] < pivot) {
                if (i == hi) break;
            }
            while (pivot < a[--j]) {
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    static Random random = new Random();

    public static int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        exch(a, i, r);
        return partitionA(a, l, r);
    }

    public static int partitionA(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                exch(a, ++i, j);
            }
        }
        exch(a, i + 1, r);
        return i + 1;
    }


    public static void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static String reverseLeftWords(String s, int n) {
        char[] array = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                char temp = array[j + 1];
                array[j + 1] = array[j];
                array[j] = temp;
            }
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        int[] array = createArray();
/*//        printArray(array);
        System.out.println(new Date(System.currentTimeMillis()).toString());
        quickSort(array, 0, array.length - 1);
//        printArray(array);
        System.out.println(new Date(System.currentTimeMillis()).toString());*/

//        String aabbccddee = reverseLeftWords("AABBCCDDEE", 2);
//        System.out.println(aabbccddee);

        int element = search(new int[]{5, 7, 7, 8, 8}, 8);
        System.out.println(element);
    }


}
