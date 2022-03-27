package numArray;

class NumArray {
    int[] preSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        NumArray numArray = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
        System.out.println(numArray.sumRange(0, 2)); // return 1 ((-2) + 0 + 3)
        System.out.println(numArray.sumRange(2, 5)); // return -1 (3 + (-5) + 2 + (-1))
        System.out.println(numArray.sumRange(0, 5)); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
    }

}
