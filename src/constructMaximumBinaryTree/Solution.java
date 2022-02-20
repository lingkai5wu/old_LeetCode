package constructMaximumBinaryTree;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		int[] nums = { 3, 2, 1, 6, 0, 5 };
		TreeNode root = new Solution().constructMaximumBinaryTree(nums);
		TreeOperation.printlnTree(root);
		TreeOperation.printlnWithoutEndingNull(root);
	}

	/* ������ */
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return build(nums, 0, nums.length);
	}

	/* �� nums[lo..hi] ����ɷ����������������ظ��ڵ� */
	TreeNode build(int[] nums, int left, int right) {
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

		TreeNode root = new TreeNode(max);
		// �ݹ���ù�����������
		root.left = build(nums, left, maxi);
		root.right = build(nums, maxi + 1, right);

		return root;
	}
}
