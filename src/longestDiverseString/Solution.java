package longestDiverseString;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    class Pair {
        int freq;
        char ch;

        public Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int a = 1, b = 1, c = 7;
        System.out.println(new Solution().longestDiverseString1(a, b, c));
        System.out.println(new Solution().longestDiverseString2(a, b, c));
    }

    public String longestDiverseString1(int a, int b, int c) {
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0)
            q.add(new int[] { 0, a });
        if (b > 0)
            q.add(new int[] { 1, b });
        if (c > 0)
            q.add(new int[] { 2, c });
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) - 'a' == cur[0] && sb.charAt(n - 2) - 'a' == cur[0]) {
                if (q.isEmpty())
                    break;
                int[] next = q.poll();
                sb.append((char) (next[0] + 'a'));
                if (--next[1] != 0)
                    q.add(next);
                q.add(cur);
            } else {
                sb.append((char) (cur[0] + 'a'));
                if (--cur[1] != 0)
                    q.add(cur);
            }
        }
        return sb.toString();
    }

    public String longestDiverseString2(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        Pair[] arr = { new Pair(a, 'a'), new Pair(b, 'b'), new Pair(c, 'c') };

        while (true) {
            Arrays.sort(arr, (p1, p2) -> p2.freq - p1.freq);
            boolean hasNext = false;
            for (Pair pair : arr) {
                if (pair.freq <= 0) {
                    break;
                }
                int m = res.length();
                if (m >= 2 && res.charAt(m - 2) == pair.ch && res.charAt(m - 1) == pair.ch) {
                    continue;
                }
                hasNext = true;
                res.append(pair.ch);
                pair.freq--;
                break;
            }
            if (!hasNext) {
                break;
            }
        }

        return res.toString();
    }

}
