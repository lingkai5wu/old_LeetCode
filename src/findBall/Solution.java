package findBall;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        int[][] grid = { { 1, 1, 1, 1, 1, 1 }, { -1, -1, -1, -1, -1, -1 }, { 1, 1, 1, 1, 1, 1 },
                { -1, -1, -1, -1, -1, -1 } };
        IntegerArrayOperation.println(new Solution().findBall(grid));
    }

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];

        for (int b = 0; b < n; b++) { // С��
            int col = b;
            for (int[] row : grid) {
                int dir = row[col];
                col += dir;
                if (col < 0 || col == n || row[col] != dir) { // �����߻� V ��
                    col = -1;
                    break;
                }
            }
            res[b] = col;
        }
        return res;
    }
}
