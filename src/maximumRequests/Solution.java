package maximumRequests;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int n = 5;
		int[][] requests = { { 0, 3 }, { 3, 1 }, { 1, 2 }, { 2, 0 } };
		System.out.println(new Solution().maximumRequests(n, requests));
	}

	public int maximumRequests(int n, int[][] requests) {
		int res = 0;

		for (int i = 1; i < 1 << requests.length + 1; i++) {
			int cnt = Integer.bitCount(i);
			if (cnt <= res) {
				continue;
			}
			int[] buildings = new int[n];
			int count = 0;
			for (int j = 0; j < requests.length; j++) {
				if ((i & (1 << j)) != 0) {
					buildings[requests[j][0]]--;
					buildings[requests[j][1]]++;
					count++;
				}
			}
			boolean isEmpey = true;
			for (int x : buildings) {
				if (x != 0) {
					isEmpey = false;
					break;
				}
			}
			if (isEmpey) {
				res = Math.max(count, res);
			}
		}
		return res;
	}
}
