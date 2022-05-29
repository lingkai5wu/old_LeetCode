package largestWordCount;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

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
            // ����
            int cnt = map.getOrDefault(senders[i], 0) + 1;
            for (char c : messages[i].toCharArray()) {
                if (c == ' ') {
                    cnt++;
                }
            }
            map.put(senders[i], cnt);

            // �Ƚ�
            if (cnt > max) {
                max = cnt;
                res = senders[i];
            } else if (cnt == max) {
                // �ֵ���
                if (senders[i].compareTo(res) > 0) {
                    res = senders[i];
                }
            }
        }
        return res;
    }
}
