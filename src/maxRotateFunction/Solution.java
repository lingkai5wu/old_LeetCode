package maxRotateFunction;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 4, 3, 2, 6 };
        System.out.println(new Solution().maxRotateFunction(nums));
    }

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int f = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
            sum += nums[i];
        }
        int max = f;
        for (int i = 1; i < n; i++) {
            f = f + sum - n * nums[n - i];
            max = Math.max(f, max);
        }
        return max;
    }
}
