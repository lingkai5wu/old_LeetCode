package isUnivalTree;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        TreeNode root = BinaryTreeOperation.stringTo("[1,1,1,1,1,null,1]");
        System.out.println(new Solution().isUnivalTree(root));
    }

    public boolean isUnivalTree(TreeNode root) {
        return traverse(root, root.val);
    }

    boolean traverse(TreeNode root, int preVal) {
        if (root == null) {
            return true;
        }
        if (preVal != root.val) {
            return false;
        }
        return traverse(root.left, root.val) && traverse(root.right, root.val);
    }
}
