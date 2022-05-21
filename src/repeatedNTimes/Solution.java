package repeatedNTimes;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        int[] nums = { 2, 1, 2, 5, 3, 2 };
        System.out.println(new Solution().repeatedNTimes(nums));
    }

    public int repeatedNTimes(int[] nums) {
        boolean[] map = new boolean[10001];
        for (int n : nums) {
            if (map[n]) {
                return n;
            }
            map[n] = true;
        }
        return -1;
    }
}
