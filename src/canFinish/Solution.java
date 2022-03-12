package canFinish;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
		System.out.println(new Solution().canFinish(numCourses, prerequisites));
	}

	// �ڽӱ�
	List<Integer>[] graph;
	// ��¼һ�εݹ��ջ�еĽڵ�
	boolean[] onPath;
	// ��¼�������Ľڵ㣬��ֹ�߻�ͷ·
	boolean[] visited;
	// ��¼ͼ���Ƿ��л�
	boolean hasCycle = false;

	@SuppressWarnings("unchecked")
	public boolean canFinish(int numCourses, int[][] prerequisites) {
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
		return !hasCycle;
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
		onPath[v] = false;
	}
}
