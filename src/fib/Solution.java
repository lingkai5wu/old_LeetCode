package fib;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int n = 4;
        System.out.println(new Solution().fib1(n));
        System.out.println(new Solution().fib2(n));
    }

    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre = 0;
        int cur = 1;
        for (int i = 2; i < n + 1; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
