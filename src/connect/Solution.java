package connect;

import java.util.LinkedList;
import java.util.Queue;

//Definition for a Node.
class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node root = stringTo("[1,2,3,4,5,6,7]");

		printlnNode(new Solution().connect(root));

	}

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		connectTwoNode(root.left, root.right);
		return root;
	}

	void connectTwoNode(Node left, Node right) {
		if (left == null || right == null) {
			return;
		}

		/**** 前序遍历位置 ****/
		// 将传入的两个节点连接
		left.next = right;

		// 连接相同父节点的两个子节点
		connectTwoNode(left.left, left.right);
		connectTwoNode(right.left, right.right);
		// 连接跨越父节点的两个子节点
		connectTwoNode(left.right, right.left);
	}

	private static Node stringTo(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		Node root = new Node(Integer.parseInt(item));
		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			Node node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new Node(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new Node(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	private static String NodeToString(Node root) {
		if (root == null) {
			return "[]";
		}

		String output = "";
		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		while (!nodeQueue.isEmpty()) {
			Node node = nodeQueue.remove();

			if (node == null) {
				break;
			}

			output += String.valueOf(node.val) + ",";
			if (node.next == null) {
				output += "#,";
			}
			nodeQueue.add(node.left);
			nodeQueue.add(node.right);
		}
		return "[" + output.substring(0, output.length() - 1) + "]";
	}

	private static void printlnNode(Node root) {
		System.out.println(NodeToString(root));
	}
}
