package maxSumBST;

import binaryTree.BinaryTreeOperation;
import binaryTree.Node;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Node root = BinaryTreeOperation.stringTo("[1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]");
		System.out.println(new Solution().maxSumBST(root));
	}

	int maxSum;

	public int maxSumBST(Node root) {
		traverse(root);
		return maxSum;
	}

	int[] traverse(Node root) {
		if (root == null) {
			return new int[] { 1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
		}

		int[] left = traverse(root.left);
		int[] right = traverse(root.right);

		int[] res = new int[4]; // res的元素分别为：是否为BST、min、max、sum
		if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
			res[0] = 1;
			res[1] = Math.min(left[1], root.val);
			res[2] = Math.max(right[2], root.val);
			res[3] = left[3] + right[3] + root.val;
			maxSum = Math.max(maxSum, res[3]);
		} else {
			res[0] = 0;
		}

		return res;
	}
}
