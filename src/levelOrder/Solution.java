package levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.Node;
import tree.TreeOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        Node root = TreeOperation.stringTo("[1,null,3,2,4,null,5,6]");
        System.out.println(new Solution().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                row.add(cur.val);
                for (Node child : cur.children) {
                    q.add(child);
                }
            }
            res.add(row);
        }
        return res;
    }
}
