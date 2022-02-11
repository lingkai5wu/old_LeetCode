package minimumDifference;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	int[] nums = { 9, 4, 1, 7 };
	int k = 2;
	System.out.println(new Solution().minimumDifference(nums, k));
    }

    public int minimumDifference(int[] nums, int k) {
	Arrays.sort(nums);

	int res = nums[k - 1] - nums[0];
	for (int i = k; i < nums.length; i++) {
	    res = Math.min(res, nums[i] - nums[i - k + 1]);
	}

	return res;
    }
}
