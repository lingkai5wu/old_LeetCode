package characterReplacement;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "ABAB";
        int k = 2;
        System.out.println(new Solution().characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int n = s.length();
        int i = 0, j = 0, max = 0;
        while (j < n) {
            max = Math.max(++cnt[s.charAt(j) - 'A'], max);
            if (j - i + 1 > k + max) {
                cnt[s.charAt(i) - 'A']--;
                i++;
            }
            j++;
        }
        return j - i;
    }
}
