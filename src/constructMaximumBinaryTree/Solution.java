package constructMaximumBinaryTree;

import binaryTree.Node;
import binaryTree.BinaryTreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		int[] nums = { 3, 2, 1, 6, 0, 5 };
		Node root = new Solution().constructMaximumBinaryTree(nums);
		BinaryTreeOperation.printlnTree(root);
		BinaryTreeOperation.printlnWithoutEndingNull(root);
	}

	/* ������ */
	public Node constructMaximumBinaryTree(int[] nums) {
		return build(nums, 0, nums.length);
	}

	/* �� nums[lo..hi] ����ɷ����������������ظ��ڵ� */
	Node build(int[] nums, int left, int right) {
		// base case
		if (left > right - 1) {
			return null;
		}

		// �ҵ������е����ֵ�Ͷ�Ӧ������
		int max = nums[left], maxi = left;
		for (int i = left + 1; i < right; i++) {
			if (max < nums[i]) {
				maxi = i;
				max = nums[i];
			}
		}

		Node root = new Node(max);
		// �ݹ���ù�����������
		root.left = build(nums, left, maxi);
		root.right = build(nums, maxi + 1, right);

		return root;
	}
}
