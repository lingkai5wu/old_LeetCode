package smallestRangeI;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 0, 10 };
        int k = 2;
        System.out.println(new Solution().smallestRangeI(nums, k));
    }

    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return Math.max(max - min - 2 * k, 0);
    }
}
