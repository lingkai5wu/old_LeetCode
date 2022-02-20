package findCenter;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 2 } };
		System.out.println(new Solution().findCenter(edges));
	}

	public int findCenter(int[][] edges) {
		int a = edges[0][0], b = edges[0][1];
		if (a == edges[1][0] || a == edges[1][1]) {
			return a;
		} else {
			return b;
		}
	}
}
