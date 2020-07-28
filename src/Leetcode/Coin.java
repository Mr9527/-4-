package Leetcode;

import java.util.Arrays;

public class Coin {

    /**
     * 322. 零钱兑换
     * 给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     */
    public int minCoinArray(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    /**
     * 518. 零钱兑换 II
     * 给定不同面额的硬币和一个总金额。
     * 写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     */
    public int coinArraySum(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 求出每种硬币组成 amount 的组合数
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
