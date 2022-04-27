package pacificAtlantic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] heights = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
        System.out.println(new Solution().pacificAtlantic(heights));
    }

    int m, n;
    int[][] g;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        g = heights;
        m = g.length;
        n = g[0].length;
        Deque<int[]> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        boolean[][] res1 = new boolean[m][n], res2 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    res1[i][j] = true;
                    d1.addLast(new int[] { i, j });
                }
                if (i == m - 1 || j == n - 1) {
                    res2[i][j] = true;
                    d2.addLast(new int[] { i, j });
                }
            }
        }
        bfs(d1, res1);
        bfs(d2, res2);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res1[i][j] && res2[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    void bfs(Deque<int[]> d, boolean[][] res) {
        while (!d.isEmpty()) {
            int[] cur = d.pollFirst();
            int x = cur[0], y = cur[1], t = g[x][y];
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (res[nx][ny] || g[nx][ny] < t) {
                    continue;
                }
                d.addLast(new int[] { nx, ny });
                res[nx][ny] = true;
            }
        }
    }
}
