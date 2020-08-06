package Leetcode;

import java.util.Arrays;
import java.util.Date;

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
                System.out.print(dp[i]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    /**
     * 322. 零钱兑换，回溯实现（超时）
     */
    public int minCoinArrayToBacktrack(int[] coins, int amount) {
        return minCoinArrayToBacktrack(0, coins, amount, new int[coins.length + 1][amount + 1]);
    }

    private int minCoinArrayToBacktrack(int idxCoin, int[] coins, int amount, int[][] ints) {
        if (amount == 0) {
            return 0;
        }
        if (idxCoin < coins.length && amount > 0) {
            // 获取当前金币和剩余乘积的系数
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i <= maxVal; i++) {
                if (amount >= i * coins[idxCoin]) {
                    int cCoin = idxCoin + 1;
                    int a = amount - i * coins[idxCoin];
                    int res;
                    if (ints[cCoin][a] != 0) {
                        res = ints[cCoin][a];
                    } else {
                        res = minCoinArrayToBacktrack(cCoin, coins, a, ints);
                        ints[cCoin][a] = res;
                    }
                    if (res != -1) {
                        minCost = Math.min(minCost, res + i);
                    }
                }
            }
            return minCost == Integer.MAX_VALUE ? -1 : minCost;
        }
        return -1;
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


    public static void main(String[] args) {
        Coin coin = new Coin();
//        System.out.println("start:" + new Date(System.currentTimeMillis()));
//        int i = coin.minCoinArrayToBacktrack(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 100);
//        System.out.println(i);
//        System.out.println("end:" + new Date(System.currentTimeMillis()));
        coin.minCoinArray(new int[]{1, 2, 5}, 11);

    }
}
