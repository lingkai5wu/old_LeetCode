package singleNonDuplicate;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	int[] num = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
	System.out.println(new Solution().singleNonDuplicate(num));
    }

    public int singleNonDuplicate(int[] nums) {
	int low = 0, mid, high = nums.length - 1;
	while (low < high) {
	    mid = low + high >> 1;
	    if (nums[mid] == nums[mid ^ 1]) {
		low = mid + 1;
	    } else {
		high = mid;
	    }
	}
	return nums[low];
    }
}
