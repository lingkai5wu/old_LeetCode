package countEven;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int sum = 4;
        System.out.println(new Solution().countEven(sum));
    }

    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int n = i, sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if ((sum & 1) == 0) {
                res++;
            }
        }
        return res;
    }
}
