package insertIntoBST;

import binaryTree.BinaryTreeOperation;
import binaryTree.Node;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node root = BinaryTreeOperation.stringTo("[40,20,60,10,30,50,70]");
		int val = 25;
		BinaryTreeOperation.printlnWithoutEndingNull(new Solution().insertIntoBST(root, val));
	}

	public Node insertIntoBST(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}

		if (val < root.val) {
			root.left = insertIntoBST(root.left, val);
		} else {
			root.right = insertIntoBST(root.right, val);
		}

		return root;
	}
}
