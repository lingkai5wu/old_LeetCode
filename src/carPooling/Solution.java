package carPooling;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[][] trips = { { 2, 1, 5 }, { 3, 5, 7 } };
		int capacity = 4;
		System.out.println(new Solution().carPooling(trips, capacity));
	}

	public boolean carPooling(int[][] trips, int capacity) {
		int n = 1001;
		int[] diff = new int[n];
		for (int[] trip : trips) {
			int val = trip[0];
			int i = trip[1];
			int j = trip[2];
			diff[i] += val;
			diff[j] -= val;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += diff[i];
			if (sum > capacity) {
				return false;
			}
		}
		return true;
	}
}
