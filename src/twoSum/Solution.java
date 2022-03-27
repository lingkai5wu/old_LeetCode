package twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        IntegerArrayOperation.println(new Solution().twoSum1(nums, target));
        IntegerArrayOperation.println(new Solution().twoSum2(nums, target));
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                return new int[] { lo, hi };
            }
        }
        return new int[0];
    }
}
