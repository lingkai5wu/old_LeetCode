package removeElement;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 3, 2, 2, 3 };
        int val = 3;
        int res = new Solution().removeElement(nums, val);

        IntegerArrayOperation.println(nums, res);
    }

    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }
        }
        return j;
    }
}
