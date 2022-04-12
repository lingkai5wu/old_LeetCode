package numberOfLines;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] widths = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10 };
        String S = "abcdefghijklmnopqrstuvwxyz";
        IntegerArrayOperation.println(new Solution().numberOfLines(widths, S));
    }

    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        res[0] = 1;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            res[1] += width;
            if (res[1] > 100) {
                res[0]++;
                res[1] = width;
            }
        }
        return res;
    }
}
