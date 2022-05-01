package construct;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] grid = { { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0, 0, 0 } };
        Deque<Node> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        q.add(new Solution().construct(grid));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            sb.append("[");
            sb.append(cur.isLeaf ? 1 : 0);
            sb.append(",");
            sb.append(cur.val ? 1 : 0);
            sb.append("],");
            if (!cur.isLeaf) {
                q.add(cur.topLeft);
                q.add(cur.topRight);
                q.add(cur.bottomLeft);
                q.add(cur.bottomRight);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        int pre = grid[0][0];
        boolean flag = false;
        for (int i = 0; i < n && !flag; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != pre) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            n /= 2;
            int[][] topLeft = new int[n][n], topRight = new int[n][n], bottomLeft = new int[n][n],
                    bottomRight = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    topLeft[i][j] = grid[i][j];
                    topRight[i][j] = grid[i][j + n];
                    bottomLeft[i][j] = grid[i + n][j];
                    bottomRight[i][j] = grid[i + n][j + n];
                }
            }
            return new Node(true, false, construct(topLeft), construct(topRight), construct(bottomLeft),
                    construct(bottomRight));
        }
        return new Node(pre == 1, true);
    }
}
