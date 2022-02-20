package buildTree105;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		int[] preorder = { 3, 9, 20, 15, 7 }, inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = new Solution().buildTree(preorder, inorder);
		TreeOperation.printlnTree(root);
		TreeOperation.printlnWithoutEndingNull(root);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}

	TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
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

		// �ȹ������ǰ���ڵ�
		TreeNode root = new TreeNode(rootVal);
		// �ݹ鹹����������
		root.left = build(preorder, preStart + 1, preStart + leftSize + 1, inorder, inStart, index);
		root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
		return root;
	}
}
