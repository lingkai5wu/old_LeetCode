package totalStrength;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] strength = { 5, 4, 6 };
        System.out.println(new Solution().totalStrength(strength));
    }

    final static int MOD = 1000000007;

    public int totalStrength(int[] strength) {
        int n = strength.length;
        long res = 0;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + strength[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    if (strength[k] < min) {
                        min = strength[k];
                    }
                }
                long sum = preSum[j] - preSum[i];
                sum %= MOD;
                res += min * sum;
                res %= MOD;
            }
        }
        return (int) res;
    }
}
