package numIslands;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
		{ '0', '0', '0', '1', '1' } };
	System.out.println(new Solution().numIslands(grid));
    }

    int m, n;
    char[][] g;

    public int numIslands(char[][] grid) {
	int res = 0;
	m = grid.length;
	n = grid[0].length;
	g = grid;

	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		if (grid[i][j] == '1') {
		    res++;
		    dfs(i, j);
		}
	    }
	}
	return res;
    }

    void dfs(int i, int j) {
	if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
	    return;
	}

	if (g[i][j] == '0') {
	    return;
	}

	g[i][j] = '0';
	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	for (int[] ks : dirs) {
	    dfs(i + ks[0], j + ks[1]);
	}
    }
}
