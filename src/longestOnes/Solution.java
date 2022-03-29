package longestOnes;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int K = 2;
        System.out.println(new Solution().longestOnes(nums, K));
    }

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0, cnt = 0;
        while (j < n) {
            if (nums[j] == 1) {
                cnt++;
            }
            if (j - i + 1 > k + cnt) {
                if (nums[i] == 1) {
                    cnt--;
                }
                i++;
            }
            j++;
        }
        return j - i;
    }
}
