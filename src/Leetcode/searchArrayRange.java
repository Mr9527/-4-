package Leetcode;

public class searchArrayRange {
    public static int[] searchRange(int[] array, int k) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] == k) {
                lo = mid;
                hi = mid;
                while ((lo > 0 && array[lo - 1] == k) || (hi < array.length - 1 && array[hi + 1] == k)) {
                    if (lo > 0 && array[lo - 1] == k) {
                        lo--;
                    }
                    if (hi < array.length && array[hi + 1] == k) {
                        hi++;
                    }
                }
                return new int[]{lo, hi};
            }
            if (k < array[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }


    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
//                if ((mid == 0) || (a[mid - 1] < value)) return mid;
//                else
                high = mid - 1;
            } else {
                if ((mid < n - 1) && a[mid + 1] > value) {
                    return mid + 1;
                } else
                    low = mid + 1;
            }
        }
        return -1;
    }

    public static int serach(int[] a, int value) {
        int low = 0;
        int high = a.length;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (high >= 0 && high < a.length - 1 && a[high + 1] >= value) return high + 1;
        return -1;
    }

    public static void main(String[] args) {


        int[] element = searchRange(new int[]{2, 2}, 2);
        System.out.println("[" + element[0] + " , " + element[1] + "]");

        int bigNumber = serach(new int[]{1, 2, 3, 4, 6,7}, 5);
        System.out.println(bigNumber);
    }

}
