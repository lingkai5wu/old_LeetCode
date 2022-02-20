package simplifiedFractions;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		int n = 4;
		System.out.println(new Solution().simplifiedFractions(n));
	}

	public List<String> simplifiedFractions(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < i; j++) {
				if (gcd(i, j) == 1) {
					res.add(j + "/" + i);
				}
			}
		}
		return res;
	}

	int gcd(int a, int b) { // ŷ������㷨
		return b == 0 ? a : gcd(b, a % b);
	}
}
