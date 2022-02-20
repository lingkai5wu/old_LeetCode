package constructMaximumBinaryTree;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] nums = { 3, 2, 1, 6, 0, 5 };
		TreeNode root = new Solution().constructMaximumBinaryTree(nums);
		TreeOperation.printlnTree(root);
		TreeOperation.printlnWithoutEndingNull(root);
	}

	/* 主函数 */
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return build(nums, 0, nums.length);
	}

	/* 将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
	TreeNode build(int[] nums, int left, int right) {
		// base case
		if (left > right - 1) {
			return null;
		}

		// 找到数组中的最大值和对应的索引
		int max = nums[left], maxi = left;
		for (int i = left + 1; i < right; i++) {
			if (max < nums[i]) {
				maxi = i;
				max = nums[i];
			}
		}

		TreeNode root = new TreeNode(max);
		// 递归调用构造左右子树
		root.left = build(nums, left, maxi);
		root.right = build(nums, maxi + 1, right);

		return root;
	}
}
