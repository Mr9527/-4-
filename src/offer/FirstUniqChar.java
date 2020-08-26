package offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {

    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap();
        char[] chars = s.toCharArray();
        for (char a : chars) {
            map.put(a, !map.containsKey(a));
        }
        for (char aChar : chars) {
            if (map.get(aChar)) {
                return aChar;
            }
        }
        return ' ';
    }

    public static void main(String[] str) {
        FirstUniqChar c = new FirstUniqChar();
        char leetcode = c.firstUniqChar("leetcode");
        System.out.println(leetcode);
    }
}
