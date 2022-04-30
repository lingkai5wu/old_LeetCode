package equalSubstring;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(new Solution().equalSubstring(s, t, maxCost));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] preNum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preNum[i + 1] = preNum[i] + Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLen = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && preNum[i + 1] - preNum[j] > maxCost) {
                j++;
            }
            maxLen = Math.max(i - j + 1, maxLen);
        }
        return maxLen;
    }
}
