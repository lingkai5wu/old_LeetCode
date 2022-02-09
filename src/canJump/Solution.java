package canJump;

public class Solution {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������

	int[] nums = { 3, 2, 1, 0, 4 };
	System.out.println(new Solution().canJump1(nums));
	System.out.println(new Solution().canJump2(nums));
    }

    /**
     * ̰��
     *
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
	int len = nums.length, maxPosition = 0;
	for (int i = 0; i < len; i++) {
	    if (i > maxPosition) {
		return false;
	    }
	    maxPosition = Math.max(maxPosition, i + nums[i]);
	    if (maxPosition > len - 2) {
		return true;
	    }
	}
	return true;
    }

    /**
     * ��̬�滮
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
	int len = nums.length;
	boolean[] dp = new boolean[len];
	dp[0] = true;

	for (int i = 0; i < len; i++) {
	    for (int j = i - 1; j > -1; j--) {
		if (dp[j] && nums[j] + j > i - 1) {
		    dp[i] = true;
		    break;
		}
	    }
	}
	return dp[len - 1];
    }
}
