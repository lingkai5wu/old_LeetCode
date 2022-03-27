package isPalindrome;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int x = 121;
        System.out.println(new Solution().isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;

        }
        int n = 0;
        while (n < x) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return x == n || x == n / 10;
    }
}
