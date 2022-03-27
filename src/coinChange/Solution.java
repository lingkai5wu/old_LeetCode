package coinChange;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(new Solution().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }
}
