package coutPairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        int[] nums = { 1, 2 };
        int k = 2;
        System.out.println(new Solution().countPairs(nums, k));
    }

    public long countPairs(int[] nums, int k) {
        List<Integer> divisors = new ArrayList<>(); // Ԥ���� k ����������
        for (int d = 1; d * d <= k; d++) {
            if (k % d == 0) {
                divisors.add(d);
                if (d * d < k)
                    divisors.add(k / d);
            }
        }
        long res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) {
            res += cnt.getOrDefault(k / gcd(n, k), 0);
            for (var d : divisors) {
                if (n % d == 0) {
                    cnt.put(d, cnt.getOrDefault(d, 0) + 1);
                }
            }
        }
        return res;
    }

    int gcd(int a, int b) { // ŷ������㷨
        return b == 0 ? a : gcd(b, a % b);
    }
}
