package coutPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 1, 2, 3, 4, 5 };
		int k = 2;
		System.out.println(new Solution().coutPairs(nums, k));
	}

	public long coutPairs(int[] nums, int k) {
		long res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int key = gcd(nums[i], k);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(i)) {
				res += map.get(i);
			}
		}
		return res;
	}

	int gcd(int a, int b) { // 欧几里得算法
		return b == 0 ? a : gcd(b, a % b);
	}
}
