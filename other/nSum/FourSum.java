package nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		System.out.println(new FourSum().fourSum(nums, target));
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return nSumTarget(nums, 4, 0, target);
	}

	private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
		int sz = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		// 至少是 2Sum，且数组大小不应该小于 n
		if (n < 2 || sz < n) {
			return res;
		}
		// 2Sum 是 base case
		if (n == 2) {
			int lo = start, hi = nums.length - 1;
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
		} else {
			for (int i = start; i < sz; i++) {
				// 剪枝，参考官方题解
				long sum1 = nums[i], sum2 = sum1;
				for (int j = i + 1; j < sz && j < i + n; j++) {
					sum1 += nums[j];
				}
				if (sum1 > target) {
					break;
				}
				for (int j = sz - 1; j >= 0 && j > sz - n; j--) {
					sum2 += nums[j];
				}
				if (sum2 < target) {
					continue;
				}

				List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
				for (List<Integer> arr : sub) {
					arr.add(nums[i]);
					res.add(arr);
				}
				while (i < sz - 1 && nums[i] == nums[i + 1]) {
					i++;
				}
			}
		}
		return res;
	}
}
