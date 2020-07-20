package Leetcode;

public class PatternMatch {
    private boolean isMatch = false;

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        isMatch = false;
        match(0, 0, s.toCharArray(), p.toCharArray());
        System.out.println(isMatch);
        return isMatch;
    }

    public void match(int pi, int pj, char[] main, char[] pattern) {
        if (isMatch) {
            return;
        }
        if (pj == pattern.length) {
            if (pi == main.length) {
                isMatch = true;
            }
            return;
        }
        if (pj + 1 < pattern.length && pattern[pj + 1] == '*') {
            for (int i = 0; i <= main.length - pi; i++) {
                match(pi + i, pj + 2, main, pattern);
                boolean b = pattern[pj] != '.';
                if (pi + i == main.length || (b && main[pi + i] != pattern[pj])) {
                    break;
                }
            }
        } else if ((pi < main.length && main[pi] == pattern[pj]) || pattern[pj] == '.') {
            match(pi + 1, pj + 1, main, pattern);
        }
    }

    public static void main(String[] args) {
        PatternMatch match = new PatternMatch();
        match.isMatch("aa", "a");
        match.isMatch("aa", "a*");
        match.isMatch("ab", ".*");
        match.isMatch("aab", "c*a*b*");
        match.isMatch("mississippi", "mis*is*p*.");
        match.isMatch("ab", ".*c");
    }

}
