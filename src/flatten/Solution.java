package flatten;

import binaryTree.BinaryTreeOperation;
import binaryTree.Node;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		Node root = BinaryTreeOperation.stringTo("[1,2,5,3,4,null,6]");
		new Solution().flatten(root);
		BinaryTreeOperation.printlnTree(root);
		BinaryTreeOperation.printlnWithoutEndingNull(root);
	}

	public void flatten(Node root) {
		if (root == null)
			return;

		flatten(root.left);
		flatten(root.right);

		/**** �������λ�� ****/
		// 1�����������Ѿ�����ƽ��һ������
		Node left = root.left;
		Node right = root.right;

		// 2������������Ϊ������
		root.left = null;
		root.right = left;

		// 3����ԭ�ȵ��������ӵ���ǰ��������ĩ��
		Node p = root;
		while (p.right != null) {
			p = p.right;
		}
		p.right = right;
	}
}
