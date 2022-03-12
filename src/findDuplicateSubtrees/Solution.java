package findDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import binaryTree.BinaryTreeOperation;
import binaryTree.Node;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node root = BinaryTreeOperation.stringTo("[0,0,0,0,null,null,0,null,null,null,0]");
		for (Node node : new Solution().findDuplicateSubtrees(root)) {
			BinaryTreeOperation.printlnWithoutEndingNull(node);
		}
	}

	Map<String, Integer> count = new HashMap<>();
	List<Node> res = new ArrayList<>();

	public List<Node> findDuplicateSubtrees(Node root) {
		traverse(root);
		return res;
	}

	/* 辅助函数 */
	String traverse(Node root) {
		if (root == null) {
			return "#";
		}

		String left = traverse(root.left);
		String right = traverse(root.right);
		String subTree = left + "," + right + "," + root.val;

		int freq = count.getOrDefault(subTree, 0);
		if (freq == 1) {
			res.add(root);
		}
		count.put(subTree, freq + 1);

		return subTree;
	}
}
