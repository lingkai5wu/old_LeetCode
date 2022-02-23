package reverseOnlyLetters;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String s = "a-bC-dEf-ghIj";
		System.out.println(new Solution().reverseOnlyLetters(s));
	}

	public String reverseOnlyLetters(String s) {
		char[] cs = s.toCharArray();
		int n = cs.length;
		for (int i = 0, j = n - 1; i < j;) {
			while (i < j && !Character.isLetter(cs[i])) {
				i++;
			}
			while (i < j && !Character.isLetter(cs[j])) {
				j--;
			}

			char t = cs[i];
			cs[i++] = cs[j];
			cs[j--] = t;
		}
		return String.valueOf(cs);
	}
}
