package findDifference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums1 = { 1, 2, 3 }, nums2 = { 2, 4, 6 };
        System.out.println(new Solution().findDifference(nums1, nums2));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
            if (set1.contains(n)) {
                set1.remove(n);
            }
        }
        for (int n : nums1) {
            if (set2.contains(n)) {
                set2.remove(n);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(set1));
        res.add(new ArrayList<>(set2));
        return res;
    }
}
