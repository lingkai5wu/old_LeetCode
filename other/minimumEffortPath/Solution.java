package minimumEffortPath;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int minimumEffortPath(int[][] heights) {
		int m = heights.length, n = heights[0].length;
		// ���壺�� (0, 0) �� (i, j) ����С���������� effortTo[i][j]
		int[][] effortTo = new int[m][n];
	}
}
