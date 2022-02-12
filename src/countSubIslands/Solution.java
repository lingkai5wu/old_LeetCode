package countSubIslands;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	int[][] grid1 = { { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 },
		{ 1, 0, 1, 0, 1 } },
		grid2 = { { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
			{ 1, 0, 0, 0, 1 } };
	System.out.println(new Solution().countSubIslands(grid1, grid2));
    }

    int m, n;
    int[][] g;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
	int res = 0;
	m = grid1.length;
	n = grid1[0].length;

	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		if (grid2[i][j] == 1 && grid1[i][j] == 0) {
		    dfs(i, j);
		}
	    }
	}

	g = grid2;
	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		if (grid2[i][j] == 1) {
		    dfs(i, j);
		    res++;
		}
	    }
	}
	return res;
    }

    private void dfs(int i, int j) {
	if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
	    return;
	}

	if (g[i][j] == 0) {
	    return;
	}

	g[i][j] = 0;
	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	for (int[] ks : dirs) {
	    dfs(i + ks[0], j + ks[1]);
	}
    }
}
