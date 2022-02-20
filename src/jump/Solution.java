package jump;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(new Solution().jump1(nums));
		System.out.println(new Solution().jump2(nums));
	}

	/**
	 * 贪心 维护maxPosition 表示step步数下能够跳到的最远位置
	 *
	 * @param nums
	 * @return
	 */
	public int jump1(int[] nums) {
		int len = nums.length, end = 0, maxPosition = 0, steps = 0;
		for (int i = 0; i < len - 1; i++) {
			maxPosition = Math.max(maxPosition, i + nums[i]);
			if (i == end) {
				end = maxPosition;
				steps++;
			}
		}
		return steps;
	}

	/**
	 * 动态规划 维护dp[] 表示从1达到第i个位置需要的最少步数
	 *
	 * @param nums
	 * @return
	 */
	public int jump2(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		dp[0] = 0;
		for (int i = 1; i < len; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (j + nums[j] + 1 > i && dp[j] + 1 < min) {
					min = dp[j] + 1;
				}
			}
			dp[i] = min;
		}
		return dp[len - 1];
	}
}
