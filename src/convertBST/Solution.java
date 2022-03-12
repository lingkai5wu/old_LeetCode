package convertBST;

import binaryTree.TreeNode;
import binaryTree.BinaryTreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		TreeNode root = BinaryTreeOperation.stringTo("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
		TreeNode res = new Solution().convertBST(root);
		BinaryTreeOperation.printlnTree(res);
		BinaryTreeOperation.printlnWithoutEndingNull(res);
	}

	public TreeNode convertBST(TreeNode root) {
		traverse(root);
		return root;
	}

	int sum = 0;

	void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		traverse(root.right);
		sum += root.val;
		root.val = sum;
		traverse(root.left);
	}
}
