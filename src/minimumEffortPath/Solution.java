package minimumEffortPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        int[][] heights = { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };
        System.out.println(new Solution().minimumEffortPath(heights));
    }

    int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // ���壺�� (0, 0) �� (i, j) ����С���������� effortTo[i][j]
        int[][] effortTo = new int[m][n];
        // dp table ��ʼ��Ϊ������
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        // base case����㵽������С���ľ��� 0
        effortTo[0][0] = 0;

        // ���ȼ����У�effortFromStart ��С������ǰ��
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.effortFromStart - b.effortFromStart;
        });

        // ����� (0, 0) ��ʼ���� BFS
        pq.offer(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curX = curState.x;
            int curY = curState.y;
            int curEffortFromStart = curState.effortFromStart;

            // �����յ���ǰ����
            if (curX == m - 1 && curY == n - 1) {
                return curEffortFromStart;
            }

            if (curEffortFromStart > effortTo[curX][curY]) {
                continue;
            }
            // �� (curX, curY) ����������װ�����
            for (int[] neighbor : adj(heights, curX, curY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                // ����� (curX, curY) �ﵽ (nextX, nextY) ������
                int effortToNextNode = Math.max(effortTo[curX][curY],
                        Math.abs(heights[curX][curY] - heights[nextX][nextY]));
                // ���� dp table
                if (effortTo[nextX][nextY] > effortToNextNode) {
                    effortTo[nextX][nextY] = effortToNextNode;
                    pq.offer(new State(nextX, nextY, effortToNextNode));
                }
            }
        }
        // �����������ﵽ��� return
        return -1;
    }

    class State {
        int x, y;
        int effortFromStart;

        State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }

    List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            neighbors.add(new int[] { nx, ny });
        }
        return neighbors;
    }
}
