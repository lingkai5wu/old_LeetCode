package longestPalindrome;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "aaaaaa";
        System.out.println(new Solution().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1, begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] arr = s.toCharArray();

        // 本题 dp 无需初始化，且可以将 i 的范围缩小到 i < j
        // 左闭右闭的边界情况：(j-1) - (i+1) + 1 < 2 --> j - i < 3
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[i] != arr[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

//	for (boolean[] row : dp) {
//	    for (boolean is : row) {
//		System.out.print((is ? 1 : 0) + " ");
//	    }
//	    System.out.println();
//	}

        return s.substring(begin, begin + maxLen);
    }
}
