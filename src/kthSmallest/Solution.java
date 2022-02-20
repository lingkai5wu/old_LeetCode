package kthSmallest;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		TreeNode root = TreeOperation.stringTo("[3,1,4,null,2]");
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
