package nextGreaterElement;

import java.util.ArrayDeque;
import java.util.Deque;

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

	// 未实现！！
	public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int[] res = new int[m];
		for (int i = 0; i < m; i++) {
			res[i] = -1;
			Deque<Integer> s = new ArrayDeque<>();
			for (int j = n - 1; j >= 0; j--) {
				while (!s.isEmpty() && s.peek() <= nums2[j]) {
					s.pop();
				}
				res[i] = s.isEmpty() ? -1 : s.peek();
				s.push(nums2[j]);
			}
		}
		return res;
	}
}
