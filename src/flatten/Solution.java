package flatten;

import binaryTree.BinaryTreeOperation;
import binaryTree.Node;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node root = BinaryTreeOperation.stringTo("[1,2,5,3,4,null,6]");
		new Solution().flatten(root);
		BinaryTreeOperation.printlnTree(root);
		BinaryTreeOperation.printlnWithoutEndingNull(root);
	}

	public void flatten(Node root) {
		if (root == null)
			return;

		flatten(root.left);
		flatten(root.right);

		/**** 后序遍历位置 ****/
		// 1、左右子树已经被拉平成一条链表
		Node left = root.left;
		Node right = root.right;

		// 2、将左子树作为右子树
		root.left = null;
		root.right = left;

		// 3、将原先的右子树接到当前右子树的末端
		Node p = root;
		while (p.right != null) {
			p = p.right;
		}
		p.right = right;
	}
}
