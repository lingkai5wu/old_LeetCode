package deleteNode;

import binaryTree.Node;
import binaryTree.BinaryTreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node root = BinaryTreeOperation.stringTo("[5,3,6,2,4,null,7]");
		int key = 3;
		BinaryTreeOperation.printlnWithoutEndingNull(new Solution().deleteNode(root, key));
	}

	public Node deleteNode(Node root, int key) {
		if (root == null)
			return null;
		if (root.val == key) {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;
			Node minNode = getMin(root.right);
			root.val = minNode.val;
			root.right = deleteNode(root.right, minNode.val);
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		}
		return root;
	}

	Node getMin(Node node) {
		// BST 最左边的就是最小的
		while (node.left != null)
			node = node.left;
		return node;
	}
}
