package maxDistance;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[][] grid = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		System.out.println(new Solution().maxDistance(grid));
	}

	public int maxDistance(int[][] grid) {
		int n = grid.length;
		int[][] res = new int[n][n];
		Deque<int[]> d = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
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
				if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1)
					continue;
				if (res[nx][ny] != -1)
					continue;
				res[nx][ny] = res[x][y] + 1;
				d.add(new int[] { nx, ny });
			}
		}

		int max = -1;
		for (int[] row : res) {
			for (int is : row) {
				max = Math.max(max, is);
			}
		}
		return max == 0 ? -1 : max;
	}
}
