package countNumbersWithUniqueDigits;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int n = 2;
        System.out.println(new Solution().countNumbersWithUniqueDigits(n));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 10;
        for (int i = 1, pre = 9; i < n; i++) {
            int cur = pre * (10 - i);
            res += cur;
            pre = cur;
        }
        return res;
    }
}
