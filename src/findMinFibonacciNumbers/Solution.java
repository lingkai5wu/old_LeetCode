package findMinFibonacciNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int k = 7;
		System.out.println(new Solution().findMinFibonacciNumbers(k));
	}

	public int findMinFibonacciNumbers(int k) {
		List<Integer> f = new ArrayList<>();
		f.add(1);
		int a = 1, b = 1;
		while (a + b < k + 1) {
			int c = a + b;
			f.add(c);
			a = b;
			b = c;
		}

		int res = 0;
		while (k > 0) {
			int l = 0, r = f.size() - 1;
			while (l < r) {
				int mid = l + r + 1 >> 1;
				if (f.get(mid) <= k) {
					l = mid;
				} else {
					r = mid - 1;
				}
			}
			k -= f.get(r);
			res++;
		}
		return res;
	}
}
