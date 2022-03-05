package nextGreaterElement;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import array.IntegerArrayOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
		IntegerArrayOperation.println(new Solution().nextGreaterElement1(nums1, nums2));
		IntegerArrayOperation.println(new Solution().nextGreaterElement2(nums1, nums2));
	}

	public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int[] res = new int[m];
		for (int i = 0; i < m; i++) {
			res[i] = -1;
			for (int j = 0; j < n; j++) {
				if (nums1[i] == nums2[j]) {
					for (int k = j + 1; k < n; k++) {
						if (nums2[k] > nums2[j]) {
							res[i] = nums2[k];
							break;
						}
					}
				}
			}
		}
		return res;
	}

	public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		Map<Integer, Integer> map = new HashMap<>();
		Deque<Integer> stack = new LinkedList<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
				stack.pop();
			}
			map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
			stack.push(nums2[i]);
		}

		int[] res = new int[m];
		for (int i = 0; i < m; i++) {
			res[i] = map.get(nums1[i]);
		}
		return res;
	}
}
