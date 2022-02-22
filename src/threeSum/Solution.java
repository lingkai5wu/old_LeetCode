package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(new Solution().threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		int n = nums.length;
		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				return res;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int target = -nums[i], k = n - 1;
			for (int j = i + 1; j < n; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				while (j < k && nums[j] + nums[k] > target) {
					k--;
				}
				if (j == k) {
					break;
				}
				if (nums[j] + nums[k] == target) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					res.add(list);
				}
			}
		}
		return res;
	}
}
