package maximumWealth;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] accounts = { { 1, 2, 3 }, { 3, 2, 1 } };
        System.out.println(new Solution().maximumWealth(accounts));
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int n : account) {
                sum += n;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
