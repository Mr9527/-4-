package codeing_thought.dynamic_programming;

public class IsInterleave {

    /*
     * 回溯算法解决
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null) s1 = "";
        if (s2 == null) s2 = "";
        if (s3 == null) s3 = "";
        //通过“备忘录”来统计重复子问题，遇到后直接返回
        return check(s1, s2, s3, 0, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    private boolean check(String s1, String s2, String s3, int i, int j, int k, Boolean[][] notes) {
        if (notes[i][j] != null) return notes[i][j];
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (k >= s3.length()) {
            return notes[i][j] = false;
        }
        if (i < s1.length()) {
            if (s1.charAt(i) == s3.charAt(k) && check(s1, s2, s3, i + 1, j, k + 1, notes)) return true;
        }
        if (j < s2.length()) {
            if (s2.charAt(j) == s3.charAt(k) && check(s1, s2, s3, i, j + 1, k + 1, notes)) return true;
        }
        return notes[i][j] = false;
    }

    // 采用动态规划得方式来
    public boolean isInterleaveDp(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] notes = new boolean[n + 1][m + 1];
        notes[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    notes[i][j] = notes[i][j] || notes[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    notes[i][j] = notes[i][j] || notes[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p);
                }
            }
        }
        for (boolean[] note : notes) {
            System.out.println();
            for (boolean b : note) {
                System.out.print(b ? "● " : "■ ");
            }
        }
        return notes[n][m];
    }

    // 利用滚动数组优化
    public boolean isInterleaveDp2(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        System.out.println("------------one line array ---------------");
        for (boolean b : f) {
            System.out.print(b ? "● " : "■ ");
        }
        System.out.println();
        return f[m];
    }

    public static void main(String[] args) {
        IsInterleave interleave = new IsInterleave();
        boolean result = interleave.isInterleaveDp2("aabcc", "dbbca", "aadbbcbcac");
        interleave.isInterleaveDp("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(result);
    }
}
