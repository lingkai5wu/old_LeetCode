package missingRolls;

import java.util.Arrays;

import array.IntegerArrayOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] rolls = { 1, 5, 6 };
		int mean = 3, n = 4;
		IntegerArrayOperation.println(new Solution().missingRolls(rolls, mean, n));
	}

	public int[] missingRolls(int[] rolls, int mean, int n) {
		int m = rolls.length;
		int sum = mean * (m + n);
		for (int roll : rolls) {
			sum -= roll;
		}
		if (sum > 6 * n || sum < n) {
			return new int[0];
		}
		int[] res = new int[n];
		Arrays.fill(res, sum / n);
		for (int i = 0; i < sum % n; i++) {
			res[i]++;
		}
		return res;
	}
}
