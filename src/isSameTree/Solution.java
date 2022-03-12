package isSameTree;

import binaryTree.Node;
import binaryTree.BinaryTreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node p = BinaryTreeOperation.stringTo("[1,2,3]");
		Node q = BinaryTreeOperation.stringTo("[1,2,3]");

		BinaryTreeOperation.printlnTree("p", p);
		BinaryTreeOperation.printlnTree("q", q);

		System.out.println(new Solution().isSameTree(p, q));
	}

	public boolean isSameTree(Node p, Node q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null || (p.val != q.val)) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
