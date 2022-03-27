package minDeletion;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 1, 1, 2, 3, 5 };
        System.out.println(new Solution().minDeletion1(nums));
    }

    // 贪心
    public int minDeletion1(int[] nums) {
        // res 为删除的个数
        int n = nums.length, res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res++;
            } else {
                i++;
            }
        }
        // n - res 为删除后数组长度，若为奇数则还需删除最后一个元素
        return res + (n - res) % 2;
    }

    // 栈模拟
    public int minDeletion2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[0]);
        for (int i = 1; i < n; i++) {
            if (stack.size() % 2 == 0) {
                stack.push(nums[i]);
            } else if (nums[i] != stack.peek()) {
                stack.push(nums[i]);
            }
        }
        int res = n - stack.size();
        return res + res % 2;
    }
}
