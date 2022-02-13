package searchBST;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	TreeNode root = TreeOperation.stringTo("[4,2,7,1,3]");
	int val = 2;
	TreeOperation.printlnWithoutEndingNull(new Solution().searchBST(root, val));
    }

    public TreeNode searchBST(TreeNode root, int val) {
	if (root == null) {
	    return null;
	}

	if (root.val == val) {
	    return root;
	}
	return searchBST(root.val > val ? root.left : root.right, val);
    }
}
