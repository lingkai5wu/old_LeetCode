package inorderSuccessor;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        TreeNode root = BinaryTreeOperation.stringTo("[5,3,6,1,4,null,null,null,2]");
        BinaryTreeOperation.printlnTree(root);
        TreeNode p = new TreeNode(4);
        TreeNode res = new Solution().inorderSuccessor(root, p);
        System.out.println(res == null ? null : res.val);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        TreeNode res = null;
        while (root != null) {
            if (p.val < root.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

}
