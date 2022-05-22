package minimumLines;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] stockPrices = { { 1, 0 }, { 9, 10 }, { 2, 0 } };
        System.out.println(new Solution().minimumLines(stockPrices));
    }

    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length, res = 0;
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        double k = 0;
        for (int i = 0; i < n - 1; i++) {
            int x1 = stockPrices[i][0];
            long y1 = stockPrices[i][1];
            int x2 = stockPrices[i + 1][0];
            int y2 = stockPrices[i + 1][1];
            if (i == 0) {
                k = 1.0 * (y2 - y1) / (x2 - x1);
                res++;
                continue;
            }
            double curK = 1.0 * (y2 - y1) / (x2 - x1);
            if (Double.compare(k, curK) == 0) {
                continue;
            }
            k = curK;
            res++;
        }
        return res;
    }
}
