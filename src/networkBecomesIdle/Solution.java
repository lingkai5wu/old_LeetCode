package networkBecomesIdle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[][] edges = { { 0, 1 }, { 1, 2 } };
		int[] patience = { 0, 2, 1 };
		System.out.println(new Solution().networkBecomesIdle(edges, patience));
	}

	class State {
		int id;
		int distFromStart;

		State(int id, int distFromStart) {
			this.id = id;
			this.distFromStart = distFromStart;
		}
	}

	public int networkBecomesIdle(int[][] edges, int[] patience) {
		int n = patience.length;
		@SuppressWarnings("unchecked")
		List<Integer>[] graph = new List[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int[] edge : edges) {
			int u = edge[0], v = edge[1];
			graph[u].add(v);
			graph[v].add(u);
		}
		int[] distTo = new int[n];
		Arrays.fill(distTo, Integer.MAX_VALUE);
		distTo[0] = 0;

		Queue<State> pq = new PriorityQueue<>((a, b) -> a.distFromStart - b.distFromStart);
		pq.add(new State(0, 0));

		while (!pq.isEmpty()) {
			State curState = pq.poll();
			int curNodeID = curState.id;
			int curDistFromStart = curState.distFromStart;

			if (curDistFromStart > distTo[curNodeID]) {
				continue;
			}

			for (int nextNodeID : graph[curNodeID]) {
				int distToNextNode = distTo[curNodeID] + 1;
				if (distTo[nextNodeID] > distToNextNode) {
					distTo[nextNodeID] = distToNextNode;
					pq.offer(new State(nextNodeID, distToNextNode));
				}
			}
		}

		int ans = 0;
		for (int i = 1; i < n; i++) {
			int d = distTo[i] * 2, p = patience[i];
			int cur = d <= p ? d : (d - 1) / p * p + d;
			if (cur > ans)
				ans = cur;
		}
		return ans + 1;
	}
}
