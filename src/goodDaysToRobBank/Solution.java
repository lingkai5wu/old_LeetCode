package goodDaysToRobBank;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] security = { 1, 2, 3, 4, 5, 6 };
        int time = 2;
        System.out.println(new Solution().goodDaysToRobBank1(security, time));
        System.out.println(new Solution().goodDaysToRobBank2(security, time));
    }

    public List<Integer> goodDaysToRobBank1(int[] security, int time) {
        int n = security.length;
        int[] g = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] == security[i - 1]) {
                continue;
            }
            g[i] = security[i] > security[i - 1] ? 1 : -1;
        }

        int[] a = new int[n + 1], b = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i + 1] = a[i] + (g[i] == 1 ? 1 : 0);
            b[i + 1] = b[i] + (g[i] == -1 ? 1 : 0);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = time + 1; i < n - time + 1; i++) {
            int c1 = a[i] - a[i - time], c2 = b[i + time] - b[i];
            if (c1 == 0 && c2 == 0) {
                res.add(i - 1);
            }
        }
        return res;
    }

    public List<Integer> goodDaysToRobBank2(int[] security, int time) {
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[n - i - 1] <= security[n - i]) {
                right[n - i - 1] = right[n - i] + 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
