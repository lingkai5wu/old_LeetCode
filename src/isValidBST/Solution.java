package isValidBST;

import binaryTree.Node;
import binaryTree.BinaryTreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node root = BinaryTreeOperation.stringTo("[5,1,4,null,null,3,6]");
		System.out.println(new Solution().isValidBST(root));
	}

	public boolean isValidBST(Node root) {
		return isValidBST(root, null, null);
	}

	boolean isValidBST(Node root, Node min, Node max) {
		if (root == null) {
			return true;
		}

		if ((min != null && root.val <= min.val) || (max != null && root.val >= max.val)) {
			return false;
		}

		return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
	}
}
