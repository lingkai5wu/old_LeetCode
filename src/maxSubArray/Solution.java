package maxSubArray;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	int[] nums = { 5, 4, -1, 7, 8 };
	System.out.println(new Solution().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
	int dp = 0, max = Integer.MIN_VALUE;
	for (int n : nums) {
	    dp = Math.max(dp + n, n);
	    max = Math.max(dp, max);
	}
	return max;
    }
}
