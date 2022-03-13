package minimumEffortPath;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int minimumEffortPath(int[][] heights) {
		int m = heights.length, n = heights[0].length;
		// 定义：从 (0, 0) 到 (i, j) 的最小体力消耗是 effortTo[i][j]
		int[][] effortTo = new int[m][n];
	}
}
