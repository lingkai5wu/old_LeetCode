package rearrangeCharacters;

public class Solution {

    public static void main(String[] args) {
        String s = "codecodecodecode", target = "codecode";
        System.out.println(new Solution().rearrangeCharacters(s, target));
    }

    public int rearrangeCharacters(String s, String target) {
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (char c : s.toCharArray()) {
            cnt1[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            cnt2[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (cnt2[i] == 0) {
                continue;
            }
            res = Math.min(cnt1[i] / cnt2[i], res);
        }
        return res;
    }
}
