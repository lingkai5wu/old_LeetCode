package isSymmetric;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.Node;
import binaryTree.BinaryTreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node root = BinaryTreeOperation.stringTo("[1,2,2,3,4,4,3]");
		System.out.println(new Solution().isSymmetric1(root));
		System.out.println(new Solution().isSymmetric2(root));
	}

	public boolean isSymmetric1(Node root) {
		return check(root.left, root.right);
	}

	boolean check(Node p, Node q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
	}

	public boolean isSymmetric2(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node p = queue.poll();
			Node q = queue.poll();
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
