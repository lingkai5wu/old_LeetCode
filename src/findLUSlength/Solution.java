package findLUSlength;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		String a = "aba", b = "cdc";
		System.out.println(new Solution().findLUSlength(a, b));
	}

	public int findLUSlength(String a, String b) {
		if (a.equals(b)) {
			return -1;
		}
		return Math.max(a.length(), b.length());
	}
}
