package trailingZeroes;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int n = 60;
		System.out.println(new Solution().trailingZeroes(n));
	}

	public int trailingZeroes(int n) {
		int res = 0;
		while (n > 0) {
			n /= 5;
			res += n;
		}
		return res;
	}
}
