package string_matching;

public class KMP {


    public int search(String main, String model) {
        char[] a = main.toCharArray();
        char[] b = model.toCharArray();
        int[] next = getNext(b);
        int j = 0;
        for (int i = 0; i < main.length(); i++) {
            while (j > 0 && a[i] != b[j]) {
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                j++;
            }
            if (j == b.length) {
                return i - b.length + 1;
            }
        }
        return -1;
    }

    private int[] getNext(char[] array) {
        int[] next = new int[array.length];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < array.length; i++) {
            while ((k != -1 && array[k + 1] != array[i])) {
                k = next[k];
            }
            if (array[k + 1] == array[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        int i = kmp.search("abcadbcdba", "cdb");
        System.out.println(i);
    }
}
