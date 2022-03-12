package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOperation {

	private static void prettyPrintlnTree(Node node, String prefix, boolean isLeft) {
		if (node == null) {
			System.out.println("Empty tree");
			return;
		}

		if (node.right != null) {
			prettyPrintlnTree(node.right, prefix + (isLeft ? "©¦   " : "    "), false);
		}

		System.out.println(prefix + (isLeft ? "©¸©¤©¤ " : "©°©¤©¤ ") + node.val);

		if (node.left != null) {
			prettyPrintlnTree(node.left, prefix + (isLeft ? "    " : "©¦   "), true);
		}
	}

	public static void println(Node root) {
		System.out.println(treeNodeToString(root, true));
	}

	public static void printlnWithoutNull(Node root) {
		System.out.println(treeNodeToString(root, false));
	}

	public static void printlnWithoutEndingNull(Node root) {
		StringBuilder sb = new StringBuilder(treeNodeToString(root, true));
		int len = sb.length();
		while (sb.length() > 7 && sb.substring(len - 7, len - 1).equals(", null")) {
			sb.delete(len - 7, len - 1);
			len = sb.length();
		}
		System.out.println(sb.toString());
	}

	public static void printlnTree(Node node) {
		prettyPrintlnTree(node, "", true);
	}

	public static void printlnTree(String str, Node node) {
		System.out.println(str);
		prettyPrintlnTree(node, "", true);
	}

	public static Node stringTo(String input) {
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

	private static String treeNodeToString(Node root, boolean needNull) {
		if (root == null) {
			return "[]";
		}

		String output = "";
		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		while (!nodeQueue.isEmpty()) {
			Node node = nodeQueue.remove();

			if (node == null) {
				if (needNull) {
					output += "null, ";
				}
				continue;
			}

			output += String.valueOf(node.val) + ", ";
			nodeQueue.add(node.left);
			nodeQueue.add(node.right);
		}
		return "[" + output.substring(0, output.length() - 2) + "]";
	}
}