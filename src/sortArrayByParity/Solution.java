package sortArrayByParity;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 3, 1, 2, 4 };
        IntegerArrayOperation.println(new Solution().sortArrayByParity1(nums));
        IntegerArrayOperation.println(new Solution().sortArrayByParity2(nums));
        IntegerArrayOperation.println(new Solution().sortArrayByParity3(nums));
    }

    public int[] sortArrayByParity1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] % 2 == 0) {
                res[i++] = nums[j];
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] % 2 == 1) {
                res[i++] = nums[j];
            }
        }
        return res;
    }

    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[i++] = num;
            } else {
                res[j--] = num;
            }
        }
        return res;
    }

    public int[] sortArrayByParity3(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 0) {
                i++;
            }
            while (i < j && nums[j] % 2 == 1) {
                j--;
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }
        return nums;
    }
}
