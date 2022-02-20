package trap;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(new Solution().trap1(height));
		System.out.println(new Solution().trap2(height));
		System.out.println(new Solution().trap3(height));
	}

	/**
	 * 动态规划
	 */
	public int trap1(int[] height) {
		int len = height.length;
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];

		leftMax[0] = height[0];
		for (int i = 1; i < len; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}
		rightMax[len - 1] = height[len - 1];
		for (int j = len - 2; j > -1; j--) {
			rightMax[j] = Math.max(rightMax[j + 1], height[j]);
		}

		int res = 0;
		for (int i = 0; i < len; i++) {
			res += Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		return res;
	}

	/**
	 * 单调栈
	 */
	public int trap2(int[] height) {
		Deque<Integer> stack = new LinkedList<>();

		int res = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
				int top = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
				int left = stack.peek();
				int currWidth = i - left - 1;
				int currHeight = Math.min(height[left], height[i]) - height[top];
				res += currWidth * currHeight;
			}
			stack.push(i);
		}
		return res;
	}

	/**
	 * 双指针
	 */
	public int trap3(int[] height) {
		int res = 0;
		int left = 0, right = height.length - 1;
		int leftMax = 0, rightMax = 0;
		while (left < right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);
			if (height[left] < height[right]) {
				res += leftMax - height[left];
				++left;
			} else {
				res += rightMax - height[right];
				--right;
			}
		}
		return res;
	}
}
