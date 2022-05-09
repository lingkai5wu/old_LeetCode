package diStringMatch;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "III";
        IntegerArrayOperation.println(new Solution().diStringMatch(s));
    }

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        int j = 0, k = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = j++;
            } else {
                res[i] = k--;
            }
        }
        res[n] = j;
        return res;
    }
}
