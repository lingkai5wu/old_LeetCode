package allPathsSourceTarget;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] parents = { { 1, 2 }, { 3 }, { 3 }, {} };
        System.out.println(new Solution().allPathsSourceTarget(parents));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0);
        return res;
    }

    void traverse(int[][] graph, int s) {
        path.addLast(s);
        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        for (int v : graph[s]) {
            traverse(graph, v);
        }

        path.removeLast();
    }
}
