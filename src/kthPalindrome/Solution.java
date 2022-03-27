package kthPalindrome;

import array.LongArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] queries = { 1, 2, 3, 4, 5, 90 };
        int intLength = 3;
        LongArrayOperation.println(new Solution().kthPalindrome(queries, intLength));
    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            int q = queries[i];
            int base = (int) Math.pow(10, (intLength - 1) / 2);
            if (q > 9 * base) {
                res[i] = -1;
                continue;
            }
            String s = Integer.toString(base + q - 1);
            StringBuilder rs = new StringBuilder(s);
            rs.reverse();
            res[i] = Long.parseLong(s + rs.substring(intLength % 2));
        }
        return res;
    }
}
