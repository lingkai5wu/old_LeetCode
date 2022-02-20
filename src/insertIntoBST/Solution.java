package insertIntoBST;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		TreeNode root = TreeOperation.stringTo("[40,20,60,10,30,50,70]");
		int val = 25;
		TreeOperation.printlnWithoutEndingNull(new Solution().insertIntoBST(root, val));
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}

		if (val < root.val) {
			root.left = insertIntoBST(root.left, val);
		} else {
			root.right = insertIntoBST(root.right, val);
		}

		return root;
	}
}
