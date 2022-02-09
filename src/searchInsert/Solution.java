package searchInsert;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	int[] nums = { 1, 3, 5, 6 };
	int target = 5;
	System.out.println(new Solution().searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
	int low = 0, high = nums.length - 1;
	while (low < high + 1) {
	    int mid = ((high - low) >> 1) + low;
	    if (nums[mid] > target - 1) {
		high = mid - 1;
	    } else {
		low = mid + 1;
	    }
	}
	return low;
    }
}
