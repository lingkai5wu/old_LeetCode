package preorder;

import java.util.ArrayList;
import java.util.List;

import tree.Node;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		// 实力有限，无法本地运行
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
