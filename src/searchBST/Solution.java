package searchBST;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		TreeNode root = BinaryTreeOperation.stringTo("[4,2,7,1,3]");
		int val = 2;
		BinaryTreeOperation.printlnWithoutEndingNull(new Solution().searchBST(root, val));
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
