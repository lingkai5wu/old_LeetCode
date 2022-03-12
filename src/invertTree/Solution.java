package invertTree;

import binaryTree.TreeNode;
import binaryTree.BinaryTreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		TreeNode root = BinaryTreeOperation.stringTo("[4,2,7,1,3,6,9]");

		BinaryTreeOperation.printlnTree("after", root);
		new Solution().invertTree(root);
		BinaryTreeOperation.printlnTree("before", root);

		BinaryTreeOperation.println(root);

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
}
