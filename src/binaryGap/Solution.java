package binaryGap;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int n = 22;
        System.out.println(new Solution().binaryGap(n));
    }

    public int binaryGap(int n) {
        int res = 0;
        for (int i = 0, j = -1; n > 0; i++) {
            if ((n & 1) == 1) {
                if (j != -1) {
                    res = Math.max(res, i - j);
                }
                j = i;
            }
            n >>= 1;
        }
        return res;
    }
}
