package weeklyContest284;

import java.util.ArrayList;
import java.util.List;

public class Q4 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	List<int[]>[] graph;

	public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
		buildGraph(n, edges);
		/*
		 * 思路：
		 * 应该是深度优先遍历？
		 * 1 分别找src1和src2到dest的所有路线and边权和
		 * 2 路线排列组合，求得边权和最小的子图
		 * 
		 * 后续，猜对了一半，确实类似BFS
		 * 不过不是排列组合，是分解路径 + 枚举中间节点 + dijkstra
		 */
	}

	void buildGraph(int n, int[][] edges) {
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] is : edges) {
			graph[is[0]].add(new int[] { is[1], is[2] });
		}
	}
}
