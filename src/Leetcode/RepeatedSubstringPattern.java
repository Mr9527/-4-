package Leetcode;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class RepeatedSubstringPattern {

    /**
     * 如果一个长度为 n 的字符串 s 可以由它的一个长度为 n` 的子串 s` 重复多次构成
     * 那么
     * n 一定是 n` 的倍数
     * s` 一定是 s 的前缀
     * 对于任意的 i 都属于 [n` n)  ，所以 s[i]=s[i-n`]
     * 时间复杂度为 O(n^2) 可用 KMP 算法优化致 O(n)
     */
    public boolean repeatedSubStringPattern(String s) {
        int length = s.length();
        for (int i = 1; i * 2 <= length; i++) {
            if (length % i == 0) {
                boolean match = true;
                for (int j = i; j < length; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }

                }
                if (match) {
                    return true;
                }
            }
        }

        return false;
    }
}
