package minimumObstacles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0 } };
        System.out.println(new Solution().minimumObstacles(grid));
    }

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        @SuppressWarnings("unchecked")
        List<int[]>[] graph = new List[m * n];
        for (int i = 0; i < m * n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    graph[i * n + j].add(new int[] { (i - 1) * n + j, grid[i - 1][j] });
                }
                if (i + 1 < m) {
                    graph[i * n + j].add(new int[] { (i + 1) * n + j, grid[i + 1][j] });
                }
                if (j - 1 >= 0) {
                    graph[i * n + j].add(new int[] { i * n + j - 1, grid[i][j - 1] });
                }
                if (j + 1 < n) {
                    graph[i * n + j].add(new int[] { i * n + j + 1, grid[i][j + 1] });
                }
            }
        }
        return dijkstra(0, m * n - 1, graph);
    }

    class State {
        // 图节点的 id
        int id;
        // 从 start 节点到当前节点的距离
        int distFromStart;

        State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    // 输入一个起点 start，计算从 start 到其他节点的最短距离
    int dijkstra(int start, int end, List<int[]>[] graph) {
        // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        // 从起点 start 开始进行 BFS
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;
            if (curNodeID == end) {
                return curDistFromStart;
            }
            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }

            // 将 curNode 的相邻节点装入队列
            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int distToNextNode = distTo[curNodeID] + neighbor[1];
                // 更新 dp table
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
