package countMaxOrSubsets;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 2, 2, 2 };
		System.out.println(new Solution().countMaxOrSubsets(nums));
	}

	public int countMaxOrSubsets(int[] nums) {
		int n = nums.length;
		int max = 0, cnt = 0;
		for (int i = 0; i < 1 << n; i++) {
			int res = 0;
			for (int j = 0; j < n; j++) {
				if (((i >> j) & 1) == 1) {
					res |= nums[j];
				}
			}
			if (res > max) {
				max = res;
				cnt = 1;
			} else if (res == max) {
				cnt++;
			}
		}
		return cnt;
	}
}
