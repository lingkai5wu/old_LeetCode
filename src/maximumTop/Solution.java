package maximumTop;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 6, 44, 95, 55, 43, 68, 6, 40, 10, 10, 44, 76, 12, 95, 21, 55, 88, 32, 68 };
        int k = 21;
        System.out.println(new Solution().maximumTop(nums, k));
    }

    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
//		k 为偶数合并至后续
//		if (n == 1) {
//			if (k % 2 == 1) {
//				return -1;
//			} else {
//				return nums[0];
//			}
//		}
        if (n == 1 && k % 2 == 1) {
            return -1;
        }

//		int max = Integer.MIN_VALUE;
        int max = (k < n) ? nums[k] : nums[0];
        for (int i = 0; i < n && i < k - 1; i++) {
            max = Math.max(nums[i], max);
        }
//		第 k+1 个元素最大 合并至 max 初始化
//		if (k < n && nums[k] > max) {
//			return nums[k];
//		}
        return max;
    }
}
