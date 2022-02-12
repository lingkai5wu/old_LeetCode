package closedIsland;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	int[][] grid = { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 1, 1, 0 },
		{ 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
	System.out.println(new Solution().closedIsland(grid));
    }

    int m, n;
    int[][] g;

    public int closedIsland(int[][] grid) {
	int res = 0;
	m = grid.length;
	n = grid[0].length;
	g = grid;

	for (int i = 0; i < m; i++) {
	    dfs(i, 0);
	    dfs(i, n - 1);
	}

	for (int j = 0; j < n; j++) {
	    dfs(0, j);
	    dfs(m - 1, j);
	}

	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		if (grid[i][j] == 0) {
		    res++;
		    dfs(i, j);
		}
	    }
	}
	return res;
    }

    private void dfs(int i, int j) {
	if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
	    return;
	}

	if (g[i][j] == 1) {
	    return;
	}

	g[i][j] = 1;
	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	for (int[] ks : dirs) {
	    dfs(i + ks[0], j + ks[1]);
	}
    }
}
