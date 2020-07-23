package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*46. 全排列
        给定一个 没有重复 数字的序列，返回其所有可能的全排列。

        示例:

        输入: [1,2,3]
        输出:
        [
        [1,2,3],
        [1,3,2],
        [2,1,3],
        [2,3,1],
        [3,1,2],
        [3,2,1]
        ]*/
public class Permute {

    private List<List<Integer>> list;

    public List<List<Integer>> permute(int[] nums) {
        list = new LinkedList<>();
        boolean[] marks = new boolean[nums.length];
        backtracking(nums, marks, new LinkedList<Integer>());
        return list;
    }

    private void backtracking(int[] nums, boolean[] marks, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            list.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!marks[i]) {
                marks[i] = true;
                path.add(nums[i]);
                backtracking(nums, marks, path);
                path.removeLast();
                marks[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> lists = permute.permute1(new int[]{1, 1, 1, 2});
        for (List<Integer> list : lists) {
            System.out.println();
            list.forEach(System.out::print);
        }
    }

    // 如果序列中包含重复的元素，需要求出所有不重复的序列
    public List<List<Integer>> permute1(int[] nums) {
        list = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] marks = new boolean[nums.length];
        backtracking1(nums, marks, new LinkedList<>());
        return list;
    }

    private void backtracking1(int[] nums, boolean[] marks, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            list.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (marks[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !marks[i - 1]) {
                continue;
            }
            marks[i] = true;
            path.add(nums[i]);
            backtracking1(nums, marks, path);
            marks[i] = false;
            path.removeLast();
        }
    }


}
