package codeing_thought.dynamic_programming;

import java.util.Stack;

public class ClimbStairs {

    // 递推公式回溯实现 时间复杂度为 O(2^n)
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 备忘录强化 将重复的结果已经计算过直接返回 时间复杂 O(n)
    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return climbStairsMemo(memo, n);
    }

    private int climbStairsMemo(int[] memo, int n) {
        if (memo[n] < 0) {
            return memo[n];
        }
        if (n == 1) {
            return memo[n] = 1;
        } else if (n == 2) {
            return memo[n] = 2;
        } else {
            memo[n] = climbStairsMemo(memo, n - 1) + climbStairsMemo(memo, n - 2);
        }
        return memo[n];
    }

    //通过动态规划来实现 时间复杂O(n) 空间复杂 O(n)
    public int climbStairsDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 通过滚动数组优化空间复杂度，每次我们只关心第 i-1 和 i-2 项，不需要存储整个动态规划的结果
    public int climbStairDp2(int n) {
        int p = 1;
        int q = 2;
        for (int i = 3; i <= n; i++) {
            int r = q + p;
            p = q;
            q = r;
        }
        return q;
    }
}
