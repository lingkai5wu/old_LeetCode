package flatten;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		TreeNode root = TreeOperation.stringTo("[1,2,5,3,4,null,6]");
		new Solution().flatten(root);
		TreeOperation.printlnTree(root);
		TreeOperation.printlnWithoutEndingNull(root);
	}

	public void flatten(TreeNode root) {
		if (root == null)
			return;

		flatten(root.left);
		flatten(root.right);

		/**** 后序遍历位置 ****/
		// 1、左右子树已经被拉平成一条链表
		TreeNode left = root.left;
		TreeNode right = root.right;

		// 2、将左子树作为右子树
		root.left = null;
		root.right = left;

		// 3、将原先的右子树接到当前右子树的末端
		TreeNode p = root;
		while (p.right != null) {
			p = p.right;
		}
		p.right = right;
	}
}
