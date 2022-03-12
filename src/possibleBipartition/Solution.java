package possibleBipartition;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int n = 4;
		int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
		System.out.println(new Solution().possibleBipartition(n, dislikes));
	}

	List<Integer>[] graph;
	boolean[] visited;
	boolean[] color;
	boolean flag = true;

	@SuppressWarnings("unchecked")
	public boolean possibleBipartition(int n, int[][] dislikes) {
		graph = new LinkedList[n + 1]; // 从 1 到 n
		visited = new boolean[n + 1];
		color = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int[] is : dislikes) {
			int v = is[1];
			int w = is[0];
			graph[v].add(w);
			graph[w].add(v);
		}

		for (int v = 1; v < n + 1; v++) {
			if (!visited[v]) { // 染色才需要这个判断！否则写在 traverse 的 base case 即可
				traverse(v);
			}
		}
		return flag;
	}

	void traverse(int v) {
		if (!flag) {
			return;
		}
		visited[v] = true;
		for (int w : graph[v]) {
			if (!visited[w]) {
				color[w] = !color[v];
				traverse(w);
			} else {
				if (color[w] == color[v]) {
					flag = false;
				}
			}
		}
	}
}
