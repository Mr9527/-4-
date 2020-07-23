package Leetcode;

public class MinPathSum {
    private int minSum = Integer.MAX_VALUE;

    /**
     * 回溯算法
     */
    public int minPathSum(int[][] grid) {
        int[][] used = new int[grid.length][grid[0].length];
        findPath(grid, 0, 0, 0, used);
        return minSum == Integer.MAX_VALUE ? 0 : minSum;
    }

    private void findPath(int[][] grid, int sum, int row, int col, int[][] used) {
        int i = sum + grid[row][col];
        if (row == grid.length - 1 && col == grid[row].length - 1) {
            sum = i;
            if (sum < minSum) {
                minSum = sum;
            }
            return;
        }
        if (row <= grid.length - 1 && col <= grid[row].length - 1 && used[row][col] == i && sum != 0) {
            return;
        }
        used[row][col] = i;
        if (row < grid.length - 1) {
            findPath(grid, i, row + 1, col, used);
        }
        if (row <= grid.length - 1 && col < grid[row].length - 1) {
            findPath(grid, i, row, col + 1, used);
        }
    }

    /**
     * 动态规划
     */
    public int minPathSum1(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        if (row == 0 || column == 0) return 0;
        int[] dp = new int[column];
        dp[0] = grid[0][0];
        for (int j = 1; j < column; j++) {
            dp[j] = grid[0][j] + dp[j - 1];
        }
        for (int i = 1; i < row; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < column; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        return dp[column-1];
    }

    public static void main(String[] args) {
        MinPathSum pathSum = new MinPathSum();
        int sum = pathSum.minPathSum1(new int[][]{{10, 3, 1}, {1, 5, 1}, {4, 2, 1}});
//        int sum = pathSum.minPathSum(new int[][]{{1, 2, 5}, {3, 2, 1}});
        System.out.println(sum);
    }
}
