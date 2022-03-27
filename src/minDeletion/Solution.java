package minDeletion;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        int[] nums = { 1, 1, 2, 3, 5 };
        System.out.println(new Solution().minDeletion1(nums));
    }

    // ̰��
    public int minDeletion1(int[] nums) {
        // res Ϊɾ���ĸ���
        int n = nums.length, res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res++;
            } else {
                i++;
            }
        }
        // n - res Ϊɾ�������鳤�ȣ���Ϊ��������ɾ�����һ��Ԫ��
        return res + (n - res) % 2;
    }

    // ջģ��
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
