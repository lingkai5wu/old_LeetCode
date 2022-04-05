package countPrimeSetBits;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int left = 842, right = 888;
        System.out.println(new Solution().countPrimeSetBits(left, right));
    }

    static int n = Integer.SIZE + 1;
    static boolean[] hash = new boolean[n];
    static {
        out: for (int i = 2; i < n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue out;
                }
            }
            hash[i] = true;
        }
    }

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i < right + 1; i++) {
            int x = i, cnt = 0;
            while (x > 0) {
                x -= (x & -x);
                cnt++;
            }
            if (hash[cnt]) {
                res++;
            }
        }
        return res;
    }
}
