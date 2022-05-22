package maximumBags;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] capacity = { 2, 3, 4, 5 }, rocks = { 1, 2, 4, 4 };
        int additionalRocks = 2;
        System.out.println(new Solution().maximumBags(capacity, rocks, additionalRocks));
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] need = new int[n];
        for (int i = 0; i < n; i++) {
            need[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(need);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (need[i] > additionalRocks) {
                break;
            }
            additionalRocks -= need[i];
            res++;
        }
        return res;
    }
}
