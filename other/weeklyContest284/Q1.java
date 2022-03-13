package weeklyContest284;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 2, 2, 2, 2, 2 };
		int key = 2, k = 2;
		System.out.println(new Q1().findKDistantIndices(nums, key, k));
	}

	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		List<Integer> res = new ArrayList<>();
		int n = nums.length;
		boolean flag[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (nums[i] == key) {
				for (int j = i - k; j <= i + k; j++) {
					if (j >= 0 && j < n && !flag[j]) {
						res.add(j);
						flag[j] = true;
					}
				}
			}
		}
		return res;
	}
}
