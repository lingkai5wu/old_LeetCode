package findDuplicates;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(new Solution().findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            if (nums[Math.abs(n) - 1] < 0) {
                res.add(Math.abs(n));
            } else {
                nums[Math.abs(n) - 1] *= -1;
            }
        }
        return res;
    }
}
