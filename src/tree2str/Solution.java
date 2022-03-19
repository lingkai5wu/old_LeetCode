package tree2str;

import binaryTree.BinaryTreeOperation;
import binaryTree.Node;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		Node root = BinaryTreeOperation.stringTo("[1,2,3,null,4]");
		System.out.println(new Solution().tree2str(root));
	}

	StringBuilder sb = new StringBuilder();

	// ���ύʱ�� TreeNode �滻 Node
	public String tree2str(Node root) {
		// base case
		if (root == null) {
			return "";
		}
		traverse(root);
		return sb.toString();
	}

	void traverse(Node root) {
		sb.append(root.val);
		// �������ǿ�
		if (root.left != null) {
			sb.append("(");
			traverse(root.left);
			sb.append(")");
			// ���������ˣ��������ǿ�
		} else if (root.right != null) {
			sb.append("()");
		}
		// �����������Ƿ�գ��������ǿ�
		if (root.right != null) {
			sb.append("(");
			traverse(root.right);
			sb.append(")");
		}
	}
}
