package totalSteps;

public class Solution {

    public static void main(String[] args) {
        int[] nums = { 7, 14, 4, 14, 13, 2, 6, 13 };
        System.out.println(new Solution().totalSteps(nums));
    }

    public int totalSteps(int[] nums) {
        int max = Integer.MIN_VALUE;
        int res = 0, step = 0, pre = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= max) {
                max = num;
                step = 0;
                pre = Integer.MIN_VALUE;
            } else {
                if (pre <= num) {
                    step++;
                }
                pre = num;
            }
            res = Math.max(step, res);
        }
        return res;
    }
}
