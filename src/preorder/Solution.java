package preorder;

import java.util.ArrayList;
import java.util.List;

import tree.Node;
import tree.TreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node root = TreeOperation.stringTo("[1,null,3,2,4,null,5,6]");
		System.out.println(new Solution().preorder(root));
	}

	List<Integer> res = new ArrayList<>();

	public List<Integer> preorder(Node root) {
		traverse(root);
		return res;
	}

	void traverse(Node root) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		for (Node child : root.children) {
			traverse(child);
		}
	}
}
