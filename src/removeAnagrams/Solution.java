package removeAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String[] words = { "abba", "baba", "bbaa", "cd", "cd" };
        System.out.println(new Solution().removeAnagrams(words));
    }

    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        String pre = "";
        for (int i = 0; i < n; i++) {
            char[] cs = words[i].toCharArray();
            Arrays.sort(cs);
            String cur = new String(cs);
            if (pre.equals(cur)) {
                continue;
            }
            res.add(words[i]);
            pre = cur;
        }
        return res;
    }
}
