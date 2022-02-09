package lengthOfLongestSubstring;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	String s = "abcabcbb";
	System.out.println(new Solution().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
	HashMap<Character, Integer> map = new HashMap<>();
	int max = 0, start = 0;
	for (int i = 0; i < s.length(); i++) {
	    char ch = s.charAt(i);
	    if (map.containsKey(ch)) {
		start = Math.max(map.get(ch) + 1, start);
	    }
	    max = Math.max(max, i - start + 1);
	    map.put(ch, i);
	}
	return max;
    }
}
