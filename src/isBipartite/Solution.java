package isBipartite;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        System.out.println(new Solution().isBipartite(graph));
    }

    int[][] graph;
    boolean[] visited;
    boolean[] color;
    boolean flag = true;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        this.graph = graph;

        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                traverse(v);
            }
        }
        return flag;
    }

    void traverse(int v) {
        if (!flag) {
            return;
        }
        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                color[w] = !color[v];
                traverse(w);
            } else {
                if (color[w] == color[v]) {
                    flag = false;
                }
            }
        }
    }
}
