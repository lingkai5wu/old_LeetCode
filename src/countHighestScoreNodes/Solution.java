package countHighestScoreNodes;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		int[] parents = { -1, 2, 0, 2, 0 };
		System.out.println(new Solution().countHighestScoreNodes(parents));
	}

	// ���ڽӱ��ʾ��һ�ö�����
	int[][] tree;
	HashMap<Long, Integer> scoreToCount = new HashMap<>();

	public int countHighestScoreNodes(int[] parents) {
		buildTree(parents);
		countNode(0);
		// �������������ֵĴ���
		long maxScore = 0;
		for (long score : scoreToCount.keySet()) {
			maxScore = Math.max(maxScore, score);
		}
		return scoreToCount.get(maxScore);
	}

	// ����������еĽڵ����
	int countNode(int root) {
		if (root == -1) {
			return 0;
		}
		// �������нڵ�����
		int n = tree.length;
		int leftCount = countNode(tree[root][0]);
		int rightCount = countNode(tree[root][1]);

		int otherCount = n - leftCount - rightCount - 1;
		long score = (long) Math.max(leftCount, 1) * Math.max(rightCount, 1) * Math.max(otherCount, 1);
		// ������ score ����
		scoreToCount.put(score, scoreToCount.getOrDefault(score, 0) + 1);

		return leftCount + rightCount + 1;
	}

	// �� parents ����ת���ɳ�����������ڽӱ���ʽ��
	void buildTree(int[] parents) {
		int n = parents.length;
		tree = new int[n][2];
		for (int i = 0; i < n; i++) {
			// �ȶ���ʼ���ɿ�ָ��
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
