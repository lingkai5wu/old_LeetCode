package hasAlternatingBits;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int n = 5;
        System.out.println(new Solution().hasAlternatingBits1(n));
        System.out.println(new Solution().hasAlternatingBits2(n));
    }

    public boolean hasAlternatingBits1(int n) {
        int pre = -1, cur;
        while (n > 0) {
            cur = n & 1;
            if ((pre ^ cur) == 0) {
                return false;
            }
            pre = cur;
            n >>= 1;
        }
        return true;
    }

    public boolean hasAlternatingBits2(int n) {
        // (101)2 ^ (10)2 = (111)2
        int x = n ^ (n >> 1);
        // (111)2 & (1000)2 = (0000)2
        return (x & (x + 1)) == 0;
    }
}
