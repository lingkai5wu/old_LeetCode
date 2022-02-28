package maximumDifference;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 7, 1, 5, 4 };
		System.out.println(new Solution().maximumDifference(nums));
	}

	public int maximumDifference(int[] nums) {
		int n = nums.length;
		int premin = nums[0], res = -1;
		for (int i = 1; i < n; i++) {
			if (nums[i] > premin) {
				res = Math.max(nums[i] - premin, res);
			} else {
				premin = nums[i];
			}
		}
		return res;
	}
}
