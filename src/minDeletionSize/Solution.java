package minDeletionSize;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String[] strs = { "zyx", "wvu", "tsr" };
        System.out.println(new Solution().minDeletionSize(strs));
    }

    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        int res = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
