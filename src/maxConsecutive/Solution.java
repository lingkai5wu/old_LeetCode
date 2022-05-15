package maxConsecutive;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int bottom = 2, top = 9;
        int[] special = { 4, 6 };
        System.out.println(new Solution().maxConsecutive(bottom, top, special));
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        int n = special.length;
        int res = 0;
        Arrays.sort(special);
        res = Math.max(special[0] - bottom, res);
        for (int i = 1; i < n; i++) {
            res = Math.max(special[i] - special[i - 1] - 1, res);
        }
        return Math.max(top - special[n - 1], res);
    }
}
