package validUtf8;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] data = { 197, 130, 1 };
        System.out.println(new Solution().validUtf8(data));
    }

    public boolean validUtf8(int[] data) {
        int n = 0;
        for (int bit : data) {
            if (bit >> 7 == 1) { // n字节字符
                if ((bit >> 6 & 1) == 1) { // n字节字符的第一字节
                    int i = 6;
                    while ((bit >> i & 1) == 1) {
                        n++;
                        i--;
                    }
                    if (n > 3) {
                        return false;
                    }
                } else {
                    n--;
                }
            }
        }
        return n == 0;
    }
}
