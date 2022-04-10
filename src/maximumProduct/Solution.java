package maximumProduct;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 24, 5, 64, 53, 26, 38 };
        int k = 54;
        System.out.println(new Solution().maximumProduct(nums, k));
    }

    public int maximumProduct(int[] nums, int k) {
        long res = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
        }
        for (int i = 0; i < k; i++) {
            int cur = pq.poll() + 1;
            pq.add(cur);
        }
        for (int n : pq) {
            res *= n;
            res %= 1000000007;
        }
        return (int) res;
    }
}
