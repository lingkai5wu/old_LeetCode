package maxArea;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(new Solution().maxArea(height));
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = Math.max(Math.min(height[i], height[j]) * (j - i), res);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
