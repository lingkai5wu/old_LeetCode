package findDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		TreeNode root = TreeOperation.stringTo("[0,0,0,0,null,null,0,null,null,null,0]");
		for (TreeNode node : new Solution().findDuplicateSubtrees(root)) {
			TreeOperation.printlnWithoutEndingNull(node);
		}
	}

	Map<String, Integer> count = new HashMap<>();
	List<TreeNode> res = new ArrayList<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		traverse(root);
		return res;
	}

	/* 辅助函数 */
	String traverse(TreeNode root) {
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
