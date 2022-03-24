package imageSmoother;

import array.Int2dArrayOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[][] img = { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } };
		Int2dArrayOperation.println(new Solution().imageSmoother(img));
	}

	public int[][] imageSmoother(int[][] img) {
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
}
