package complexNumberMultiply;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String num1 = "1+-1i", num2 = "1+-1i";
		System.out.println(new Solution().complexNumberMultiply(num1, num2));
	}

	public String complexNumberMultiply(String num1, String num2) {
		int a[] = getComplex(num1);
		int b[] = getComplex(num2);
		return (a[0] * b[0] - a[1] * b[1]) + "+" + (a[0] * b[1] + a[1] * b[0]) + "i";
	}

	int[] getComplex(String n) {
		String s[] = n.split("\\+|i");
		return new int[] { Integer.valueOf(s[0]), Integer.valueOf(s[1]) };
	}
}
