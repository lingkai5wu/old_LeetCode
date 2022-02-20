package gridIllumination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import array.IntegerArrayOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int n = 5;
		int[][] lamps = { { 0, 0 }, { 4, 4 } }, queries = { { 1, 1 }, { 1, 1 } };
		IntegerArrayOperation.println(new Solution().gridIllumination(n, lamps, queries));
	}

	public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
		long N = n;
		Map<Integer, Integer> row = new HashMap<>(), col = new HashMap<>();
		Map<Integer, Integer> diagonal = new HashMap<>(), antiDiagonal = new HashMap<>();
		Set<Long> points = new HashSet<>();

		for (int[] l : lamps) {
			int x = l[0], y = l[1];
			if (points.contains(x * N + y))
				continue;
			increment(row, x);
			increment(col, y);
			increment(diagonal, x - y);
			increment(antiDiagonal, x + y);
			points.add(x * N + y);
		}

		int m = queries.length;
		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			int[] q = queries[i];
			int x = q[0], y = q[1];
			if (row.containsKey(x) || col.containsKey(y) || diagonal.containsKey(x - y)
					|| antiDiagonal.containsKey(x + y)) {
				ans[i] = 1;
			}

			int[][] dirs = new int[][] { { 0, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, 0 },
					{ 1, -1 }, { 1, 1 } };
			for (int[] d : dirs) {
				int nx = x + d[0], ny = y + d[1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (points.contains(nx * N + ny)) {
					points.remove(nx * N + ny);
					decrement(row, nx);
					decrement(col, ny);
					decrement(diagonal, nx - ny);
					decrement(antiDiagonal, nx + ny);
				}
			}
		}
		return ans;
	}

	void increment(Map<Integer, Integer> map, int key) {
		map.put(key, map.getOrDefault(key, 0) + 1);
	}

	void decrement(Map<Integer, Integer> map, int key) {
		if (map.get(key) == 1) {
			map.remove(key);
		} else {
			map.put(key, map.get(key) - 1);
		}
	}
}
