package weeklyContest284;

import java.util.ArrayList;
import java.util.List;

public class Q4 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	List<int[]>[] graph;

	public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
		buildGraph(n, edges);
		/*
		 * ˼·��
		 * Ӧ����������ȱ�����
		 * 1 �ֱ���src1��src2��dest������·��and��Ȩ��
		 * 2 ·��������ϣ���ñ�Ȩ����С����ͼ
		 * 
		 * �������¶���һ�룬ȷʵ����BFS
		 * ��������������ϣ��Ƿֽ�·�� + ö���м�ڵ� + dijkstra
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
