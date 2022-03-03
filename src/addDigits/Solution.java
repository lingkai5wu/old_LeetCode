package addDigits;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int num = 38;
		System.out.println(new Solution().addDigits1(num));
		System.out.println(new Solution().addDigits2(num));
	}

	public int addDigits1(int num) {
		while (num >= 10) {
			int t = 0;
			while (num > 0) {
				t += num % 10;
				num /= 10;
			}
			num = t;
		}
		return num;
	}

	public int addDigits2(int num) {
		return (num - 1) % 9 + 1;
	}
}
