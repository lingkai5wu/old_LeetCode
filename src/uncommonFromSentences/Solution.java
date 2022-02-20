package uncommonFromSentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import array.StringArrayOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String s1 = "this apple is sweet", s2 = "this apple is sour";
		StringArrayOperation.println(new Solution().uncommonFromSentences(s1, s2));
	}

	public String[] uncommonFromSentences(String s1, String s2) {
		Map<String, Integer> map = new HashMap<>();

		for (String word : (s1 + " " + s2).split(" ")) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		List<String> res = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key) == 1) {
				res.add(key);
			}
		}

		return res.toArray(new String[res.size()]);
	}
}
