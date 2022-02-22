package twoSum;

import java.util.HashMap;
import java.util.Map;

import array.IntegerArrayOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		IntegerArrayOperation.println(new Solution().twoSum(nums, target));
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}
}
