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
        // ͼ�ڵ�� id
        int id;
        // �� start �ڵ㵽��ǰ�ڵ�ľ���
        int distFromStart;

        State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    // ����һ����� start������� start �������ڵ����̾���
    int dijkstra(int start, int end, List<int[]>[] graph) {
        // ���壺distTo[i] ��ֵ������� start ����ڵ� i �����·��Ȩ��
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case��start �� start ����̾������ 0
        distTo[start] = 0;

        // ���ȼ����У�distFromStart ��С������ǰ��
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        // ����� start ��ʼ���� BFS
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

            // �� curNode �����ڽڵ�װ�����
            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int distToNextNode = distTo[curNodeID] + neighbor[1];
                // ���� dp table
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
