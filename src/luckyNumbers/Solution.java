package luckyNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] matrix = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
        System.out.println(new Solution().luckyNumbers(matrix));
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] minRow = new int[m];
        int[] maxCol = new int[n];
        for (int i = 0; i < m; i++) {
            minRow[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}
