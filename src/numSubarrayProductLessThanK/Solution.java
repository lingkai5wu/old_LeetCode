package numSubarrayProductLessThanK;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        System.out.println(new Solution().numSubarrayProductLessThanK1(nums, k));
        System.out.println(new Solution().numSubarrayProductLessThanK2(nums, k));
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            int num = 1;
            for (int j = i; j < n; j++) {
                num *= nums[j];
                if (num < k) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k < 2) {
            return 0;
        }
        int n = nums.length, res = 0;
        for (int i = 0, j = 0, cur = 1; i < n; i++) {
            cur *= nums[i];
            while (cur >= k) {
                cur /= nums[j++];
            }
            res += i - j + 1;
        }
        return res;
    }
}
