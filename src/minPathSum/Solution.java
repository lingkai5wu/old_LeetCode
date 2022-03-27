package minPathSum;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] grid = { { 1, 2 }, { 1, 1 } };
        System.out.println(new Solution().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m];
        dp[0] = grid[0][0];
        for (int j = 1; j < m; j++) {
            dp[j] = grid[0][j] + dp[j - 1];
        }

        for (int i = 1; i < n; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[m - 1];
    }
}
