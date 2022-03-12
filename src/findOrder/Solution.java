package findOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import array.IntegerArrayOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		IntegerArrayOperation.println(new Solution().findOrder(numCourses, prerequisites));
	}

	// 邻接表
	List<Integer>[] graph;
	// 记录一次递归堆栈中的节点和遍历过的节点，防止走回头路
	boolean[] onPath, visited;
	// 记录图中是否有环
	boolean hasCycle = false;
	// 记录后序遍历
	List<Integer> postorder = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		graph = new LinkedList[numCourses];
		onPath = new boolean[numCourses];
		visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int[] edge : prerequisites) {
			graph[edge[1]].add(edge[0]);
		}

		for (int v = 0; v < numCourses; v++) {
			traverse(v);
		}

		if (hasCycle) {
			return new int[] {};
		}
		Collections.reverse(postorder);
		return postorder.stream().mapToInt(Integer::valueOf).toArray();
	}

	void traverse(int v) {
		if (onPath[v]) {
			hasCycle = true;
		}
		if (visited[v] || hasCycle) {
			return;
		}

		visited[v] = true;
		onPath[v] = true;
		for (int w : graph[v]) {
			traverse(w);
		}
		postorder.add(v);
		onPath[v] = false;
	}
}
