package shortestToChar;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "loveleetcode";
        char c = 'e';
        IntegerArrayOperation.println(new Solution().shortestToChar1(s, c));
        IntegerArrayOperation.println(new Solution().shortestToChar2(s, c));
    }

    public int[] shortestToChar1(String s, char c) {
        int n = s.length();
        int[] res = new int[n];
        char[] cs = s.toCharArray();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            res[i] = -1;
            if (cs[i] == c) {
                q.add(i);
                res[i] = 0;
            }
        }
        int[] dirs = new int[] { -1, 1 };
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int i : dirs) {
                int next = cur + i;
                if (next > -1 && next < n && res[next] == -1) {
                    res[next] = res[cur] + 1;
                    q.add(next);
                }
            }
        }
        return res;
    }

    public int[] shortestToChar2(String s, char c) {
        int n = s.length();
        int[] res = new int[n];
        Arrays.fill(res, n);
        char[] cs = s.toCharArray();
        for (int i = 0, j = -n * 2; i < n; i++) {
            if (cs[i] == c) {
                j = i;
            }
            res[i] = i - j;
        }
        for (int i = n - 1, j = n * 2; i >= 0; i--) {
            if (cs[i] == c) {
                j = i;
            }
            res[i] = Math.min(j - i, res[i]);
        }

        return res;
    }
}
