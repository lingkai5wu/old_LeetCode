package buildTree105;

import binaryTree.BinaryTreeOperation;
import binaryTree.Node;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] preorder = { 3, 9, 20, 15, 7 }, inorder = { 9, 3, 15, 20, 7 };
		Node root = new Solution().buildTree(preorder, inorder);
		BinaryTreeOperation.printlnTree(root);
		BinaryTreeOperation.printlnWithoutEndingNull(root);
	}

	public Node buildTree(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}

	Node build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd - 1) {
			return null;
		}

		int rootVal = preorder[preStart], index = 0;
		for (int i = inStart; i < inEnd; i++) {
			if (inorder[i] == rootVal) {
				index = i;
				break;
			}
		}

		int leftSize = index - inStart;

		// 先构造出当前根节点
		Node root = new Node(rootVal);
		// 递归构造左右子树
		root.left = build(preorder, preStart + 1, preStart + leftSize + 1, inorder, inStart, index);
		root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
		return root;
	}
}
