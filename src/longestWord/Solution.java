package longestWord;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String[] words = { "rac", "rs", "ra", "on", "r", "otif", "o", "onpdu", "rsf", "rs", "ot", "oti", "racy",
				"onpd" };
		System.out.println(new Solution().longestWord(words));
	}

	public String longestWord(String[] words) {
		Arrays.sort(words, (a, b) -> {
			if (a.length() != b.length()) {
				return a.length() - b.length();
			} else {
				return b.compareTo(a);
			}
		});
		Set<String> set = new HashSet<>();
		set.add("");
		String res = "";
		for (String word : words) {
			if (set.contains(word.substring(0, word.length() - 1))) {
				set.add(word);
				res = word;
			}
		}
		return res;
	}
}
