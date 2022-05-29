package maximumImportance;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int n = 3;
        int[][] roads = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        System.out.println(new Solution().maximumImportance(n, roads));
    }

    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        long res = 0;
        for (int i = n; i > 0; i--) {
            res += degree[i - 1] * i;
            if (degree[i - 1] == 0) {
                return res;
            }
        }
        return res;
    }
}
