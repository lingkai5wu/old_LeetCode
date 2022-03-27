package highestPeak;

import java.util.ArrayDeque;
import java.util.Deque;

import array.Int2dArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] isWater = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
        int[][] res = new Solution().highestPeak(isWater);

        Int2dArrayOperation.println(res);
    }

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] res = new int[m][n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    d.add(new int[] { i, j });
                    res[i][j] = 0;
                } else {
                    res[i][j] = -1;
                }
            }
        }

        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!d.isEmpty()) {
            int[] xy = d.poll();
            int x = xy[0], y = xy[1];
            for (int[] is : dirs) {
                int nx = x + is[0], ny = y + is[1];
                if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1)
                    continue;
                if (res[nx][ny] != -1)
                    continue;
                res[nx][ny] = res[x][y] + 1;
                d.add(new int[] { nx, ny });
            }
        }
        return res;
    }
}
