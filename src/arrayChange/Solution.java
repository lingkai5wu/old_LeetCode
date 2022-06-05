package arrayChange;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 6 };
        int[][] operations = { { 1, 3 }, { 4, 7 }, { 6, 1 } };
        IntegerArrayOperation.println(new Solution().arrayChange(nums, operations));
    }

    int[] map = new int[1000001];

    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map[nums[i]] = i;
        }

        for (int[] is : operations) {
            int i = map[is[0]];
            nums[i] = is[1];
            map[is[1]] = i;
        }

        return nums;
    }
}
