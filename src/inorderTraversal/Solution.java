package inorderTraversal;

import java.util.ArrayList;
import java.util.List;

import binaryTree.BinaryTreeOperation;
import binaryTree.Node;
import list.ArrayListOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		Node root = BinaryTreeOperation.stringTo("[1,null,2,3]");
		BinaryTreeOperation.printlnTree(root);
		ArrayListOperation.println(new Solution().inorderTraversal(root));
	}

	public List<Integer> inorderTraversal(Node root) {
		List<Integer> res = new ArrayList<>();
		inorder(root, res);
		return res;
	}

	void inorder(Node root, List<Integer> res) {
		if (root == null) {
			return;
		}
		inorder(root.left, res);
		res.add(root.val);
		inorder(root.right, res);
	}
}
