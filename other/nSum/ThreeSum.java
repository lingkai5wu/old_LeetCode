package nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { -1, 0, 1, 2, -1, -4 };
		int target = 0;
		System.out.println(new ThreeSum().threeSumTarget(nums, target));
	}

	private List<List<Integer>> threeSumTarget(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
			for (List<Integer> tuple : tuples) {
				tuple.add(nums[i]);
				res.add(tuple);
			}
			while (i < n - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
		}
		return res;
	}

	private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
		int lo = start, hi = nums.length - 1;
		List<List<Integer>> res = new ArrayList<>();

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
				t.add(nums[lo]);
				t.add(nums[hi]);
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
