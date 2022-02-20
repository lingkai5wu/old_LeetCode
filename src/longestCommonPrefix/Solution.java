package longestCommonPrefix;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String[] strs = { "flower", "flow", "flight" };
		System.out.println(new Solution().longestCommonPrefix1(strs));
		System.out.println(new Solution().longestCommonPrefix2(strs));
		System.out.println(new Solution().longestCommonPrefix3(strs));
	}

	public String longestCommonPrefix1(String[] strs) {
		if (strs.length == 0) {
			return "";
		}

		String res = "";
		try {
			for (int i = 0;; i++) {
				char ch = strs[0].charAt(i);
				for (String str : strs) {
					if (ch != str.charAt(i)) {
						return res;
					}
				}
				res += ch;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		int minLength = Integer.MAX_VALUE;
		for (String str : strs) {
			minLength = Math.min(minLength, str.length());
		}
		int low = 0, high = minLength;
		while (low < high) {
			int mid = (high - low + 1) / 2 + low;
			if (isCommonPrefix(strs, mid)) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return strs[0].substring(0, low);
	}

	public boolean isCommonPrefix(String[] strs, int length) {
		String str0 = strs[0].substring(0, length);
		int count = strs.length;
		for (int i = 1; i < count; i++) {
			String str = strs[i];
			for (int j = 0; j < length; j++) {
				if (str0.charAt(j) != str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public String longestCommonPrefix3(String[] strs) {
		if (strs.length == 0)
			return "";
		String s = strs[0];
		for (String string : strs) {
			while (!string.startsWith(s)) {
				if (s.length() == 0)
					return "";
				s = s.substring(0, s.length() - 1);
			}
		}
		return s;
	}
}
