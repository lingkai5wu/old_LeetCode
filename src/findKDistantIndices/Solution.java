package findKDistantIndices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 2, 2, 2, 2, 2 };
        int key = 2, k = 2;
        System.out.println(new Solution().findKDistantIndices(nums, key, k));
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                for (int j = Math.max(i - k, 0); j < Math.min(i + k + 1, n); j++) {
                    set.add(j);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
