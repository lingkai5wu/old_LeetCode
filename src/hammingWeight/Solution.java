package hammingWeight;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        int n = 11;
        System.out.println(new Solution().hammingWeight(n));
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n -= (n & -n);
            res++;
        }
        return res;
    }
}
