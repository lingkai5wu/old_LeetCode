package minimumWeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int n = 6, src1 = 0, src2 = 1, dest = 5;
        int[][] edges = { { 0, 2, 2 }, { 0, 5, 6 }, { 1, 0, 3 }, { 1, 4, 5 }, { 2, 1, 1 }, { 2, 3, 3 }, { 2, 3, 4 },
                { 3, 4, 2 }, { 4, 5, 1 } };
        System.out.println(new Solution().minimumWeight(n, edges, src1, src2, dest));
    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        @SuppressWarnings("unchecked")
        List<int[]>[] graph = new ArrayList[n], reverseGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int[] is : edges) {
            graph[is[0]].add(new int[] { is[1], is[2] });
            reverseGraph[is[1]].add(new int[] { is[0], is[2] });
        }
        long[] src1ToMid = dijkstra(src1, graph);
        long[] src2ToMid = dijkstra(src2, graph);
        long[] destToMid = dijkstra(dest, reverseGraph);

        long res = Long.MAX_VALUE / 3;
        for (int i = 0; i < n; i++) {
            res = Math.min(src1ToMid[i] + src2ToMid[i] + destToMid[i], res);
        }
        return res < Long.MAX_VALUE / 3 ? res : -1;
    }

    class State {
        // 图节点的 id
        int id;
        // 从 start 节点到当前节点的距离
        long distFromStart;

        State(int id, long distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    long[] dijkstra(int start, List<int[]>[] graph) {
        long[] distTo = new long[graph.length];
        Arrays.fill(distTo, Long.MAX_VALUE / 3);
        distTo[start] = 0;

        Queue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.distFromStart, b.distFromStart));
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            long curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }

            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                long distToNextNode = distTo[curNodeID] + neighbor[1];
                // 更新 dp table
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }
}
