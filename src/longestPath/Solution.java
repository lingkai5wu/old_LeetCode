package longestPath;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] parent = { -1, 0, 0, 1, 1, 2 };
        String s = "abacbe";
        System.out.println(new Solution().longestPath(parent, s));
    }

    List<Integer>[] graph;
    String s;
    int res;

    @SuppressWarnings("unchecked")
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        graph = new List[n];
        this.s = s;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            graph[parent[i]].add(i);
        }

        dfs(0);

        return res + 1;
    }

    int dfs(int x) {
        int max = 0;
        for (int y : graph[x]) {
            int len = dfs(y) + 1;
            if (s.charAt(x) != s.charAt(y)) {
                res = Math.max(max + len, res);
                max = Math.max(len, max);
            }
        }
        return max;
    }
}
