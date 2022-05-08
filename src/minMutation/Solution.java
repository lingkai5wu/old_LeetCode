package minMutation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        String start = "AAAAACCC", end = "AACCCCCC";
        String[] bank = { "AAAACCCC", "AAACCCCC", "AACCCCCC" };
        System.out.println(new Solution().minMutation(start, end, bank));
    }

    public int minMutation(String start, String end, String[] bank) {
        char[] keys = { 'A', 'C', 'G', 'T' };
        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        Map<String, Integer> map = new HashMap<>();
        map.put(start, 0);
        Deque<String> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String s = q.pollFirst();
                char[] cs = s.toCharArray();
                int step = map.get(s);
                for (int i = 0; i < 8; i++) {
                    for (char key : keys) {
                        if (cs[i] == key) {
                            continue;
                        }
                        char[] clone = cs.clone();
                        clone[i] = key;
                        String sub = String.valueOf(clone);
                        if (!set.contains(sub) || map.containsKey(sub)) {
                            continue;
                        }
                        if (sub.equals(end)) {
                            return step + 1;
                        }
                        map.put(sub, step + 1);
                        q.addLast(sub);
                    }
                }
            }
        }
        return -1;
    }
}
