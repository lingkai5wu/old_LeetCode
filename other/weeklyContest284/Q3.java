package weeklyContest284;

public class Q3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 6, 44, 95, 55, 43, 68, 6, 40, 10, 10, 44, 76, 12, 95, 21, 55, 88, 32, 68 };
		int k = 21;
		System.out.println(new Q3().maximumTop(nums, k));
	}

	public int maximumTop(int[] nums, int k) {
		if (nums.length == 1) {
			if (k % 2 == 1) {
				return -1;
			} else {
				return nums[0];
			}
		}

		int n = Math.min(nums.length, k - 1);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(nums[i], max);
		}
		if (k < nums.length && nums[k] > max) {
			return nums[k];
		}
		return max;
	}
}
