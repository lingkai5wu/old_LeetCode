package findBall;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] grid = { { 1, 1, 1, 1, 1, 1 }, { -1, -1, -1, -1, -1, -1 }, { 1, 1, 1, 1, 1, 1 },
                { -1, -1, -1, -1, -1, -1 } };
        IntegerArrayOperation.println(new Solution().findBall(grid));
    }

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];

        for (int b = 0; b < n; b++) { // 小球
            int col = b;
            for (int[] row : grid) {
                int dir = row[col];
                col += dir;
                if (col < 0 || col == n || row[col] != dir) { // 到达侧边或 V 形
                    col = -1;
                    break;
                }
            }
            res[b] = col;
        }
        return res;
    }
}
