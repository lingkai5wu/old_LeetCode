package checkSubarraySum;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 1, 0 };
		int k = 2;
		System.out.println(new Solution().checkSubarraySum1(nums, k));
		System.out.println(new Solution().checkSubarraySum2(nums, k));
	}

	public boolean checkSubarraySum1(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for (int n : nums) {
			int pre = sum;
			sum += n;
			if (set.contains(sum % k)) {
				return true;
			}
			set.add(pre % k);
		}
		return false;
	}

	public boolean checkSubarraySum2(int[] nums, int k) {
		int n = nums.length;
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 2; i < n + 1; i++) {
			set.add(sum[i - 2] % k);
			if (set.contains(sum[i] % k)) {
				return true;
			}
		}
		return false;
	}
}
