package numSplits;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "aacaba";
        System.out.println(new Solution().numSplits(s));
    }

    public int numSplits(String s) {
        int n = s.length(), res = 0;
        char[] cs = s.toCharArray();
        boolean[] set = new boolean[26];
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            char c = cs[i - 1];
            if (set[c - 'a']) {
                dp[i] = dp[i - 1];
            } else {
                set[c - 'a'] = true;
                dp[i] = dp[i - 1] + 1;
            }
        }

        int cnt = 0;
        set = new boolean[n];
        for (int i = n - 1; i > 0; i--) {
            char c = cs[i];
            if (!set[c - 'a']) {
                set[c - 'a'] = true;
                cnt++;
            }
            if (dp[i] == cnt) {
                res++;
            }
        }

        return res;
    }
}
