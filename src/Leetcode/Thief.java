package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫系列问题
 */
public class Thief {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        dp[0] = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[nums.length];
    }


    public int robⅡ(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums, 0, n - 2),
                robRange(nums, 1, n - 1));
    }

    // 仅计算闭区间 [start,end] 的最优结果
    private int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, Integer> memo = new HashMap<>();

    private int robⅢ(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 抢，然后去下下家
        int do_it = root.val
                + (root.left == null ?
                0 : robⅢ(root.left.left) + robⅢ(root.left.right))
                + (root.right == null ?
                0 : robⅢ(root.right.left) + robⅢ(root.right.right));
        // 不抢，然后去下家
        int not_do = robⅢ(root.left) + robⅢ(root.right);

        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }
}
