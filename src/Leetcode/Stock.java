package Leetcode;

import java.util.HashSet;
import java.util.Stack;

public class Stock {

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意：你不能在买入股票前卖出股票。
     * 动态规划，先计算每次隔天卖出的利润。然后决策出最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = prices[i] - prices[i - 1];
        }
        int pre = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            pre = Math.max(dp[i], pre + dp[i]);
            max = Math.max(pre, max);
        }
        return Math.max(max, 0);
    }

    /**
     * 找到最低买点与最低点相对的最高卖点
     */
    public int maxProfit1(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minBuy) {
                minBuy = prices[i];
            } else if (prices[i] - minBuy > maxProfit) {
                maxProfit = prices[i] - minBuy;
            }
        }
        return maxProfit;
    }

    /**
     * 901. 股票价格跨度
     * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
     * <p>
     * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
     * <p>
     * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
     */
    class StockSpanner {
        private Stack<Integer> prices = new Stack<>();
        private Stack<Integer> widgets = new Stack<>();

        public StockSpanner() {

        }

        public int next(int price) {
            int w = 1;
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                w += widgets.pop();
            }
            prices.push(price);
            widgets.push(w);
            return w;
        }
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfitⅡ(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];
        // 0: 持有现金 1: 持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // 二维数组可以优化为滚动数组
        return dp[prices.length - 1][0];
    }

    /**
     * 统计所有的峰谷然后加起来
     */
    public int maxProfitⅡ1(int[] prices) {
        int i = 0;
        int maxProfit = 0;
        int peak = prices[0];
        int valley = prices[0];

        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
                valley = prices[i];
            }
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;

            }
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

    /**
     * 我们可以使用更加简化的逻辑，
     * 在爬坡中统计增加所有的收益，而不需要在谷之后统计每个峰值。
     * A+B+C=D   A1+A2+Ai+B...+C...=D
     */
    public int maxProfitⅡ2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        Stock stock = new Stock();
        int i = stock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}
