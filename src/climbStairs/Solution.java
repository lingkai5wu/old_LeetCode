package climbStairs;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int n = 3;
		System.out.println(new Solution().climbStairs(n));
	}

	public int climbStairs(int n) {
		int[] dp = new int[3];
		Arrays.fill(dp, 1);

		for (int i = 2; i < n + 1; i++) {
			dp[0] = dp[1] + dp[2];
			dp[2] = dp[1];
			dp[1] = dp[0];
		}
		return dp[0];
	}
}
