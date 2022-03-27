package imageSmoother;

import array.Int2dArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] img = { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } };
        Int2dArrayOperation.println(new Solution().imageSmoother1(img));
        Int2dArrayOperation.println(new Solution().imageSmoother2(img));
    }

    public int[][] imageSmoother1(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        int[][] dirs = new int[][] { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 },
                { 1, -1 }, { 1, 1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0, cnt = 0;
                for (int[] dir : dirs) {
                    int nx = i + dir[0], ny = j + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    sum += img[nx][ny];
                    cnt++;
                }
                res[i][j] = sum / cnt;
            }
        }
        return res;
    }

    public int[][] imageSmoother2(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n], preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = img[i][j] + preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = Math.max(0, i - 1), x2 = Math.min(m - 1, i + 1);
                int y1 = Math.max(0, j - 1), y2 = Math.min(n - 1, j + 1);
                int sum = preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
                int cnt = (x2 - x1 + 1) * (y2 - y1 + 1);
                res[i][j] = sum / cnt;
            }
        }
        return res;
    }
}
