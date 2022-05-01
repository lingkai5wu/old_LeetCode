package getAllElements;

import java.util.ArrayList;
import java.util.List;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        TreeNode root1 = BinaryTreeOperation.stringTo("[2,1,4]");
        TreeNode root2 = BinaryTreeOperation.stringTo("[1,0,3]");
        System.out.println(new Solution().getAllElements(root1, root2));
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i++));
            } else {
                res.add(list2.get(j++));
            }
        }
        if (i < list1.size()) {
            res.addAll(list1.subList(i, list1.size()));
        } else {
            res.addAll(list2.subList(j, list2.size()));
        }
        return res;
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
