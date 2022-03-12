package convertBST;

import binaryTree.BinaryTreeOperation;
import binaryTree.Node;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node root = BinaryTreeOperation.stringTo("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
		Node res = new Solution().convertBST(root);
		BinaryTreeOperation.printlnTree(res);
		BinaryTreeOperation.printlnWithoutEndingNull(res);
	}

	public Node convertBST(Node root) {
		traverse(root);
		return root;
	}

	int sum = 0;

	void traverse(Node root) {
		if (root == null) {
			return;
		}

		traverse(root.right);
		sum += root.val;
		root.val = sum;
		traverse(root.left);
	}
}
