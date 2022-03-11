package countHighestScoreNodes;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] parents = { -1, 2, 0, 2, 0 };
		System.out.println(new Solution().countHighestScoreNodes(parents));
	}

	// 用邻接表表示的一棵二叉树
	int[][] tree;
	HashMap<Long, Integer> scoreToCount = new HashMap<>();

	public int countHighestScoreNodes(int[] parents) {
		buildTree(parents);
		countNode(0);
		// 计算最大分数出现的次数
		long maxScore = 0;
		for (long score : scoreToCount.keySet()) {
			maxScore = Math.max(maxScore, score);
		}
		return scoreToCount.get(maxScore);
	}

	// 计算二叉树中的节点个数
	int countNode(int root) {
		if (root == -1) {
			return 0;
		}
		// 二叉树中节点总数
		int n = tree.length;
		int leftCount = countNode(tree[root][0]);
		int rightCount = countNode(tree[root][1]);

		int otherCount = n - leftCount - rightCount - 1;
		long score = (long) Math.max(leftCount, 1) * Math.max(rightCount, 1) * Math.max(otherCount, 1);
		// 给分数 score 计数
		scoreToCount.put(score, scoreToCount.getOrDefault(score, 0) + 1);

		return leftCount + rightCount + 1;
	}

	// 将 parents 数组转化成常规二叉树（邻接表形式）
	void buildTree(int[] parents) {
		int n = parents.length;
		tree = new int[n][2];
		for (int i = 0; i < n; i++) {
			// 先都初始化成空指针
			tree[i][0] = tree[i][1] = -1;
		}

		for (int i = 1; i < n; i++) {
			int val = parents[i];
			if (tree[val][0] == -1) {
				tree[val][0] = i;
			} else {
				tree[val][1] = i;
			}
		}
	}
}
