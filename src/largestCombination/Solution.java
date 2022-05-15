package largestCombination;

import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] candidates = { 16, 16, 48, 71, 62, 12, 24, 14, 17, 18, 19, 20, 10000 };
        System.out.println(new Solution().largestCombination(candidates));
    }

    static int N = 0;
    static {
        int max = (int) Math.pow(10, 7);
        while (Math.pow(2, N) < max) {
            N++;
        }
    }

    public int largestCombination(int[] candidates) {
        int[] cnt = new int[N];
        for (int num : candidates) {
            for (int i = 0, t = num; t > 0; i++, t >>= 1) {
                if ((t & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        return IntStream.of(cnt).max().getAsInt();
    }
}
