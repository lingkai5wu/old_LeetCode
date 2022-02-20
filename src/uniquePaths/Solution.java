package uniquePaths;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int m = 7, n = 3;
		System.out.println(new Solution().uniquePaths(m, n));
	}

	public int uniquePaths(int m, int n) {
		int[] dp = new int[m];
		for (int j = 0; j < m; j++) {
			dp[j] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[j] += dp[j - 1];
			}
		}
		return dp[m - 1];
	}
}
