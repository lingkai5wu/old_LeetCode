package bestRotation;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 2, 3, 1, 4, 0 };
		System.out.println(new Solution().bestRotation1(nums));
		System.out.println(new Solution().bestRotation2(nums));
	}

	// 模拟先来一次
	public int bestRotation1(int[] nums) {
		int n = nums.length;
		int maxK = 0, maxCnt = 0;
		for (int k = 0; k < n; k++) {
			int cnt = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[(i + k) % n] <= i) {
					cnt++;
				}
			}
			if (cnt > maxCnt) {
				maxCnt = cnt;
				maxK = k;
			}
		}
		return maxK;
	}

	static int N = 100010;
	static int[] c = new int[N];

	void add(int l, int r) {
		c[l] += 1;
		c[r + 1] -= 1;
	}

	public int bestRotation2(int[] nums) {
		Arrays.fill(c, 0);
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int a = (i - (n - 1) + n) % n, b = (i - nums[i] + n) % n;
			if (a <= b) {
				add(a, b);
			} else {
				add(0, b);
				add(a, n - 1);
			}
		}
		for (int i = 1; i <= n; i++)
			c[i] += c[i - 1];
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (c[i] > c[ans])
				ans = i;
		}
		return ans;
	}
}
