package pushDominoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String dominoes = "RL";
        System.out.println(new Solution().pushDominoes(dominoes));
    }

    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        Deque<int[]> d = new ArrayDeque<>();
        int n = dominoes.length();
        int[] g = new int[n];

        for (int i = 0; i < n; i++) {
            if (cs[i] == '.')
                continue;
            int dire = cs[i] == 'L' ? -1 : 1;
            d.add(new int[] { i, 1, dire });
            g[i] = 1;
        }

        while (!d.isEmpty()) {
            int[] info = d.poll();
            int loc = info[0], time = info[1], dire = info[2];
            int ne = loc + dire;
            if (ne < 0 || ne >= n)
                continue;
            if (g[ne] == 0) {
                d.add(new int[] { ne, time + 1, dire });
                g[ne] = time + 1;
                cs[ne] = dire == -1 ? 'L' : 'R';
            } else if (g[ne] == time + 1) {
                cs[ne] = '.';
                d.pollLast();
            }
        }
        return String.valueOf(cs);
    }
}
