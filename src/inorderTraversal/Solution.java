package inorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;
import list.ArrayListOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        TreeNode root = BinaryTreeOperation.stringTo("[1,null,2,3]");
        BinaryTreeOperation.printlnTree(root);
        ArrayListOperation.println(new Solution().inorderTraversal1(root));
        ArrayListOperation.println(new Solution().inorderTraversal2(root));
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
