package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int pre = 0;
        int size = s.length();
        int ans = 0;
        while (pre < size) {
            char c = s.charAt(pre);
            int count = 0;
            while (pre < size && s.charAt(pre) == c) {
                pre++;
                count++;
            }
            list.add(count);
        }
        for (int i = 1; i < list.size(); i++) {
            ans += Math.min(list.get(i), list.get(i - 1));
        }
        return ans;
    }

}
