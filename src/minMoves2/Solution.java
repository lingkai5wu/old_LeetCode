package minMoves2;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 1, 10, 2, 9 };
        System.out.println(new Solution().minMoves2(nums));
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, res = 0, i = nums[n / 2];
        for (int num : nums) {
            res += Math.abs(num - i);
        }
        return res;
    }
}
