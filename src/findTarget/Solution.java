package findTarget;

import java.util.HashSet;
import java.util.Set;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		TreeNode root = BinaryTreeOperation.stringTo("[1]");
		int k = 2;
		System.out.println(new Solution().findTarget(root, k));
	}

	Set<Integer> set = new HashSet<>();

	public boolean findTarget(TreeNode root, int k) {
		if (root == null) {
			return false;
		}
		if (set.contains(root.val)) {
			return true;
		}
		set.add(k - root.val);
		return findTarget(root.left, k) || findTarget(root.right, k);
	}
}
