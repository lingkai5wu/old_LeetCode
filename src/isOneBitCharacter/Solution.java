package isOneBitCharacter;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] bits = { 1, 1, 0, 0 };
		System.out.println(new Solution().isOneBitCharacter1(bits));
	}

	public boolean isOneBitCharacter1(int[] bits) {
		int n = bits.length, i = 0;
		while (i < n - 1) {
			i += bits[i] + 1;
		}
		return i == n - 1;
	}

	public boolean isOneBitCharacter2(int[] bits) {
		int n = bits.length, i = n - 2;
		while (i >= 0 && bits[i] == 1) {
			i--;
		}
		return ((n - 2 - i) & 1) == 0;
	}
}
