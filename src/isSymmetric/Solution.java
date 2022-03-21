package isSymmetric;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		TreeNode root = BinaryTreeOperation.stringTo("[1,2,2,3,4,4,3]");
		System.out.println(new Solution().isSymmetric1(root));
		System.out.println(new Solution().isSymmetric2(root));
	}

	public boolean isSymmetric1(TreeNode root) {
		return check(root.left, root.right);
	}

	boolean check(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
	}

	public boolean isSymmetric2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			TreeNode q = queue.poll();
			if (p == null && q == null) {
				continue;
			}
			if ((p == null || q == null) || (p.val != q.val)) {
				return false;
			}

			queue.offer(p.left);
			queue.offer(q.right);

			queue.offer(p.right);
			queue.offer(q.left);
		}
		return true;
	}
}
