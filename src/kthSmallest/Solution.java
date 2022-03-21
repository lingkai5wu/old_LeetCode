package kthSmallest;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		TreeNode root = BinaryTreeOperation.stringTo("[3,1,4,null,2]");
		int k = 1;
		System.out.println(new Solution().kthSmallest(root, k));
	}

	int res = 0, rank = 1;

	public int kthSmallest(TreeNode root, int k) {
		traverse(root, k);
		return res;
	}

	void traverse(TreeNode root, int k) {
		if (root == null) {
			return;
		}

		traverse(root.left, k);
		if (k == rank++) {
			res = root.val;
			return;
		}
		traverse(root.right, k);
	}
}
