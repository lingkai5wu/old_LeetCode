package largestWordCount;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String[] messages = { "How is leetcode for everyone", "Leetcode is useful for practice" },
                senders = { "Bob", "Charlie" };
        System.out.println(new Solution().largestWordCount(messages, senders));
    }

    public String largestWordCount(String[] messages, String[] senders) {
        int n = messages.length;
        String res = "";
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 计算
            int cnt = map.getOrDefault(senders[i], 0) + 1;
            for (char c : messages[i].toCharArray()) {
                if (c == ' ') {
                    cnt++;
                }
            }
            map.put(senders[i], cnt);

            // 比较
            if (cnt > max) {
                max = cnt;
                res = senders[i];
            } else if (cnt == max) {
                // 字典序
                if (senders[i].compareTo(res) > 0) {
                    res = senders[i];
                }
            }
        }
        return res;
    }
}
