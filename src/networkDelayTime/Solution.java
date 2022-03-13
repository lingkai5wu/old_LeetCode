package networkDelayTime;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int n = 4, k = 2;
		System.out.println(new Solution().networkDelayTime(times, n, k));
	}

	public int networkDelayTime(int[][] times, int n, int k) {
		@SuppressWarnings("unchecked")
		List<int[]>[] graph = new LinkedList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new LinkedList<>();
		}

		for (int[] edge : times) {
			graph[edge[0]].add(new int[] { edge[1], edge[2] });
		}

		int[] distTo = dijkstra(k, graph);
		int res = 0;
		for (int i = 1; i < distTo.length; i++) {
			if (distTo[i] == Integer.MAX_VALUE) {
				// 有节点不可达，返回 -1
				return -1;
			}
			res = Math.max(res, distTo[i]);
		}
		return res;
	}

	class State {
		int id;
		int distFromStart;

		State(int id, int distFromStart) {
			this.id = id;
			this.distFromStart = distFromStart;
		}
	}

	// 输入一个起点 start，计算从 start 到其他节点的最短距离
	int[] dijkstra(int start, List<int[]>[] graph) {
		int[] distTo = new int[graph.length];
		Arrays.fill(distTo, Integer.MAX_VALUE);
		// base case
		distTo[start] = 0;
		Queue<State> pq = new PriorityQueue<>((a, b) -> a.distFromStart - b.distFromStart);
		pq.add(new State(start, 0));

		while (!pq.isEmpty()) {
			State curState = pq.poll();
			int curNodeID = curState.id;
			int curDistFromStart = curState.distFromStart;

			if (curDistFromStart > distTo[curNodeID]) {
				continue;
			}

			for (int[] neighbor : graph[curNodeID]) {
				int nextNodeID = neighbor[0];
				int distToNextNode = distTo[curNodeID] + neighbor[1];
				if (distTo[nextNodeID] > distToNextNode) {
					distTo[nextNodeID] = distToNextNode;
					pq.offer(new State(nextNodeID, distToNextNode));
				}
			}
		}
		return distTo;
	}
}
