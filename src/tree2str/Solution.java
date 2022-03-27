package tree2str;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        TreeNode root = BinaryTreeOperation.stringTo("[1,2,3,null,4]");
        System.out.println(new Solution().tree2str(root));
    }

    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode root) {
        // base case
        if (root == null) {
            return "";
        }
        traverse(root);
        return sb.toString();
    }

    void traverse(TreeNode root) {
        sb.append(root.val);
        // 左子树非空
        if (root.left != null) {
            sb.append("(");
            traverse(root.left);
            sb.append(")");
            // 左子树空了，柚子树非空
        } else if (root.right != null) {
            sb.append("()");
        }
        // 不管左子树是否空，柚子树非空
        if (root.right != null) {
            sb.append("(");
            traverse(root.right);
            sb.append(")");
        }
    }
}
