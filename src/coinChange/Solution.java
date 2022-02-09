package coinChange;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	int[] coins = { 1, 2, 5 };
	int amount = 11;
	System.out.println(new Solution().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
	int[] f = new int[amount + 1];
	f[0] = 0;

	for (int i = 1; i < amount + 1; i++) {
	    f[i] = Integer.MAX_VALUE;
	    for (int coin : coins) {
		if (i > coin - 1 && f[i - coin] != Integer.MAX_VALUE) {
		    f[i] = Math.min(f[i - coin] + 1, f[i]);
		}
	    }
	}
	return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }
}
