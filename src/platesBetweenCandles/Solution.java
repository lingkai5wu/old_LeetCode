package platesBetweenCandles;

import java.util.ArrayList;
import java.util.List;

import array.IntegerArrayOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String s = "***|**|*****|**||**|*";
		int[][] queries = { { 1, 17 }, { 4, 5 }, { 14, 17 }, { 5, 11 }, { 15, 16 } };
		IntegerArrayOperation.println(new Solution().platesBetweenCandles1(s, queries));
		IntegerArrayOperation.println(new Solution().platesBetweenCandles2(s, queries));
	}

	// 方法一超时了...看了眼标签有前缀和，自己试试
	public int[] platesBetweenCandles1(String s, int[][] queries) {
		int n = queries.length;
		int[] answer = new int[n];

		for (int i = 0; i < n; i++) {
			int left = queries[i][0], right = queries[i][1];
			int cnt = 0;
			while (left < right) {
				if (s.charAt(left) != '|') {
					left++;
				} else if (s.charAt(right) != '|') {
					right--;
				} else {
					break;
				}
			}
			for (int j = left + 1; j < right; j++) {
				if (s.charAt(j) == '*') {
					cnt++;
				}
			}

			answer[i] = cnt;
		}
		return answer;
	}

	// 前缀和居然也超时了...标签还有个二分查找，但是找的是个啥??
	// 三叶的题解是 找区间 [a, b] 边缘蜡烛，吃完饭看看
	public int[] platesBetweenCandles2(String s, int[][] queries) {
		int m = queries.length, n = s.length();
		int[] answer = new int[m];
		int[] g = new int[n + 1];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '|') {
				list.add(i);
			}
			g[i + 1] += g[i] + (s.charAt(i) == '*' ? 1 : 0);
		}

		if (list.size() == 0) {
			return answer;
		}

		// 复制了，开摆
		for (int i = 0; i < m; i++) {
			int a = queries[i][0], b = queries[i][1];
			int c = -1, d = -1;
			// 找到 a 右边最近的蜡烛
			int l = 0, r = list.size() - 1;
			while (l < r) {
				int mid = l + r >> 1;
				if (list.get(mid) >= a) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			if (list.get(r) >= a) {
				c = list.get(r);
			} else {
				continue;
			}
			// 找到 b 左边最近的蜡烛
			l = 0;
			r = list.size() - 1;
			while (l < r) {
				int mid = l + r + 1 >> 1;
				if (list.get(mid) <= b) {
					l = mid;
				} else {
					r = mid - 1;
				}
			}
			if (list.get(r) <= b) {
				d = list.get(r);
			} else {
				continue;
			}
			if (c <= d) {
				answer[i] = g[d + 1] - g[c];
			}
		}
		return answer;
	}
}
