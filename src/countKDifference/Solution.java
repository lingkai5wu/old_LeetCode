package countKDifference;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        int[] nums = { 33, 90, 62, 43, 21, 96, 20, 18, 84, 74, 61, 100, 5, 11, 4, 67, 96, 18, 6, 68, 82, 32, 76, 33, 93,
                33, 71, 32, 30, 63, 37, 46, 95, 51, 63, 77, 63, 84, 52, 78, 66, 76, 66, 9, 73, 92, 79, 65, 29, 42 };
        int k = 64;
        System.out.println(new Solution().countKDifference1(nums, k));
        System.out.println(new Solution().countKDifference2(nums, k));
    }

    public int countKDifference1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countKDifference2(int[] nums, int k) {
        int res = 0, n = nums.length;
        int[] count = new int[100];

        for (int i = 0; i < n; i++) {
            int t = nums[i] - 1;
            if (t - k > -1) {
                res += count[t - k];
            }
            if (t + k < 100) {
                res += count[t + k];
            }
            count[t]++;
        }

        return res;
    }
}
