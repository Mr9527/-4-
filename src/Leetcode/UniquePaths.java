package Leetcode;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[n - 1];
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 如果有路障，那么这个点对路径的贡献就是0
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j > 0 && obstacleGrid[i][j] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[col - 1];
//        return backtrack(0, 0, obstacleGrid);
    }

    /**
     * 回溯法
     */
    private int backtrack(int row, int col, int[][] obstacleGrid) {
        if (row > obstacleGrid.length - 1 || col > obstacleGrid[row].length - 1) {
            return 0;
        }
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[col].length - 1) {
            return 1;
        }
        if (obstacleGrid[row][col] == 1) {
            return 0;
        }
        return backtrack(row + 1, col, obstacleGrid) + backtrack(row, col + 1, obstacleGrid);
    }


    public static void main(String[] args) {
        UniquePaths paths = new UniquePaths();
        System.out.println(paths.uniquePaths(7, 3));
        System.out.println(paths.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
