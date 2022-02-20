package sumOfUnique;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 1, 2, 3, 2 };
		System.out.println(new Solution().sumOfUnique1(nums));
		System.out.println(new Solution().sumOfUnique2(nums));
		System.out.println(new Solution().sumOfUnique3(nums));
	}

	public int sumOfUnique1(int[] nums) {
		int res = 0;
		Map<Integer, Integer> state = new HashMap<>();
		for (int num : nums) {
			if (!state.containsKey(num)) {
				res += num;
				state.put(num, 1);
			} else if (state.get(num) == 1) {
				res -= num;
				state.put(num, 2);
			}
		}
		return res;
	}

	public int sumOfUnique2(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length, res = 0;
		for (int i = 0; i < n;) {
			int j = i;
			while (j < n && nums[j] == nums[i])
				j++;
			if (j - i == 1)
				res += nums[i];
			i = j;
		}
		return res;
	}

	public int sumOfUnique3(int[] nums) {
		int[] count = new int[101];
		for (int i : nums)
			count[i]++;
		int res = 0;
		for (int i = 1; i <= 100; i++) {
			if (count[i] == 1)
				res += i;
		}
		return res;
	}
}
