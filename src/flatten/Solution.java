package flatten;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		TreeNode root = TreeOperation.stringTo("[1,2,5,3,4,null,6]");
		new Solution().flatten(root);
		TreeOperation.printlnTree(root);
		TreeOperation.printlnWithoutEndingNull(root);
	}

	public void flatten(TreeNode root) {
		if (root == null)
			return;

		flatten(root.left);
		flatten(root.right);

		/**** �������λ�� ****/
		// 1�����������Ѿ�����ƽ��һ������
		TreeNode left = root.left;
		TreeNode right = root.right;

		// 2������������Ϊ������
		root.left = null;
		root.right = left;

		// 3����ԭ�ȵ��������ӵ���ǰ��������ĩ��
		TreeNode p = root;
		while (p.right != null) {
			p = p.right;
		}
		p.right = right;
	}
}
