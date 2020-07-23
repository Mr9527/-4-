package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//　给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
public class LetterCombinations {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        output.clear();
        if (digits.length() > 0) {
            backtrack("", digits);
        }
        return output;
    }

    private void backtrack(String combination, String digits) {
        if (digits.length() == 0) {
            output.add(combination);
            return;
        }
        String cString = digits.substring(0, 1);
        String cPhone = phone.get(cString);
        char[] chars = cPhone.toCharArray();
        for (char aChar : chars) {
            backtrack(combination + aChar, digits.substring(1));
        }
    }

    public static void main(String[] args) {
        LetterCombinations combinations = new LetterCombinations();
        combinations.letterCombinations("789");
        for (String s : combinations.output) {
            System.out.println(s);
        }
    }
}
