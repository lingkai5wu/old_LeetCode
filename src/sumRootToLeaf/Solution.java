package sumRootToLeaf;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeOperation.stringTo("[1,0,1,0,1,0,1]");
        System.out.println(new Solution().sumRootToLeaf(root));
    }

    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        traverse(root, 0);
        return res;
    }

    private void traverse(TreeNode root, int num) {
        num = num * 2 + root.val;
        if (root.left == null && root.right == null) {
            res += num;
            return;
        }
        if (root.left != null) {
            traverse(root.left, num);
        }
        if (root.right != null) {
            traverse(root.right, num);
        }
    }
}
