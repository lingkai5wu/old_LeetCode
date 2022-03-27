package removeDuplicates;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int res = new Solution().removeDuplicates(nums);

        IntegerArrayOperation.println(nums, res);
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int i = 1;
        for (int j = 1; j < len; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
