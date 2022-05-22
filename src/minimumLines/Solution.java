package minimumLines;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] stockPrices = { { 1, 0 }, { 9, 10 }, { 2, 0 } };
        System.out.println(new Solution().minimumLines(stockPrices));
    }

    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (o1, o2) -> o1[0] - o2[0]);
        int n = stockPrices.length, res = 1;
        if (n == 1) {
            return 0;
        }
        for (int i = 2; i < n; i++) {
            int x1 = stockPrices[i][0] - stockPrices[i - 1][0];
            int y1 = stockPrices[i][1] - stockPrices[i - 1][1];
            int x2 = stockPrices[i - 1][0] - stockPrices[i - 2][0];
            int y2 = stockPrices[i - 1][1] - stockPrices[i - 2][1];
            if (x1 * y2 != y1 * x2) {
                res++;
            }
        }
        return res;
    }
}
