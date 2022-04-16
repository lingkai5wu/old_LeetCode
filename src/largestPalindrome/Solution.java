package largestPalindrome;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int n = 2;
        System.out.println(new Solution().largestPalindrome(n));
    }

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        for (int i = max; i >= 0; i--) {
            long num = i, t = i;
            while (t > 0) {
                num = num * 10 + t % 10;
                t /= 10;
            }
            for (long j = max; j * j >= num; j--) {
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return -1;
    }
}
