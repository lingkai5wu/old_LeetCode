package buildTree106;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] inorder = { 9, 3, 15, 20, 7 }, postorder = { 9, 15, 7, 20, 3 };
		TreeNode root = new Solution().buildTree(inorder, postorder);
		TreeOperation.printlnTree(root);
		TreeOperation.printlnWithoutEndingNull(root);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
	}

	TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (postStart > postEnd - 1) {
			return null;
		}

		int rootVal = postorder[postEnd - 1], index = 0;
		for (int i = inStart; i < inEnd; i++) {
			if (inorder[i] == rootVal) {
				index = i;
				break;
			}
		}

		int leftSize = index - inStart;
		TreeNode root = new TreeNode(rootVal);
		root.left = build(inorder, inStart, index, postorder, postStart, postStart + leftSize);
		root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
		return root;
	}
}
