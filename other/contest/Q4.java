package contest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q4 {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] parent = { -1, 0, 0, 0 };
        String s = "aabc";
        System.out.println(new Q4().longestPath(parent, s));
    }

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] grid = new List[n];
        for (int i = 0; i < n; i++) {
            grid[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int u = i, v = parent[i] + 1;
            grid[u].add(v);
            grid[v].add(u);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            boolean[] isVisit = new boolean[n];
            boolean[] isUse = new boolean[26];
            int len = 0;
            stack.add(i);
            while (!stack.isEmpty()) {
                for (int j = 0; j < stack.size(); j++) {
                    int cur = stack.pop();
                    char c = s.charAt(cur);
                    if (isUse[c - 'a']) {
                        continue;
                    }
                    isUse[c - 'a'] = true;
                    for (int child : grid[cur]) {
                        stack.add(child);
                    }
                }
                len++;
            }
            max = Math.max(len, max);
        }
        return max;
    }
}
