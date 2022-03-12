package findOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import array.IntegerArrayOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		IntegerArrayOperation.println(new Solution().findOrder(numCourses, prerequisites));
	}

	// �ڽӱ�
	List<Integer>[] graph;
	// ��¼һ�εݹ��ջ�еĽڵ�ͱ������Ľڵ㣬��ֹ�߻�ͷ·
	boolean[] onPath, visited;
	// ��¼ͼ���Ƿ��л�
	boolean hasCycle = false;
	// ��¼�������
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
