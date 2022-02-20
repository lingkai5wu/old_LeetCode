package pancakeSort;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] arr = { 3, 2, 4, 1 };
		System.out.println(new Solution().pancakeSort(arr));
	}

	int[] arr;
	List<Integer> res = new ArrayList<>();

	public List<Integer> pancakeSort(int[] arr) {
		this.arr = arr;
		sort(arr.length);
		return res;
	}

	void sort(int n) {
		if (n == 1) {
			return;
		}

		int max = arr[0], maxi = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxi = i;
			}
		}

		reverse(0, maxi);
		res.add(maxi + 1);

		reverse(0, n - 1);
		res.add(n);

		sort(n - 1);
	}

	void reverse(int i, int j) {
		for (int temp; i < j; i++, j--) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
