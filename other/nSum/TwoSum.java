package nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		System.out.println(new TwoSum().twoSumTarget(nums, target));
	}

	private List<List<Integer>> twoSumTarget(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);

		while (lo < hi) {
			int sum = nums[lo] + nums[hi];
			int loVal = nums[lo], hiVal = nums[hi];
			if (sum < target) {
				while (lo < hi && nums[lo] == loVal) {
					lo++;
				}
			} else if (sum > target) {
				while (lo < hi && nums[hi] == hiVal) {
					hi--;
				}
			} else {
				List<Integer> t = new ArrayList<>();
				t.add(lo);
				t.add(hi);
				res.add(t);

				while (lo < hi && nums[lo] == loVal) {
					lo++;
				}
				while (lo < hi && nums[hi] == hiVal) {
					hi--;
				}
			}
		}

		return res;
	}
}
