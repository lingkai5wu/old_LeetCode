package partitionArray;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = { 3, 6, 1, 2, 5 };
        int k = 2;
        System.out.println(new Solution().partitionArray(nums, k));
    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1, pre = nums[0];
        for (int num : nums) {
            if (num - pre > k) {
                res++;
                pre = num;
            }
        }
        return res;
    }
}
