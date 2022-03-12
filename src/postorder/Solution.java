package postorder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tree.Node;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	List<Integer> res = new ArrayList<>();

	public List<Integer> postorder(Node root) {
		traverse(root);
		return res;
	}

	void traverse(Node root) {
		if (root == null) {
			return;
		}
		for (Node child : root.children) {
			traverse(child);
		}
		res.add(root.val);
	}
}
