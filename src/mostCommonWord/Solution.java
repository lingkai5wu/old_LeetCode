package mostCommonWord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String paragraph = "Bob";
        String[] banned = {};
        System.out.println(new Solution().mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        int n = paragraph.length();
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }

        Map<String, Integer> map = new HashMap<>();
        String s = paragraph.toLowerCase();
        char[] cs = s.toCharArray();
        for (int i = 0, j = 1; j < n + 1; j++) {
            if (j < n && Character.isLetter(cs[j])) {
                continue;
            }
            String word = s.substring(i, j);
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            // 找到下个单词的第一个字符
            while (j < n && !Character.isLetter(cs[j])) {
                j++;
            }
            i = j;
        }

        String res = null;
        int maxCnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int cnt = entry.getValue();
            if (cnt > maxCnt) {
                maxCnt = cnt;
                res = word;
            }
        }
        return res;
    }
}
