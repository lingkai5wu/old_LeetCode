package countGoodRectangles;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	int[][] rectangles = { { 5, 8 }, { 3, 9 }, { 5, 12 }, { 16, 5 } };
	System.out.println(new Solution().countGoodRectangles(rectangles));
    }

    public int countGoodRectangles(int[][] rectangles) {
	int max = 0, maxCount = 0;
	for (int[] is : rectangles) {
	    int k = Math.min(is[0], is[1]);
	    if (k > max) {
		max = k;
		maxCount = 1;
	    } else if (k == max) {
		maxCount++;
	    }
	}
	return maxCount;
    }
}
