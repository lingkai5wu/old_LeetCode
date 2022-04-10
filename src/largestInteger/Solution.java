package largestInteger;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int num = 1234;
        System.out.println(new Solution().largestInteger(num));
    }

    public int largestInteger(int num) {
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        int cur = num;
        while (cur > 0) {
            if ((cur & 1) == 1) {
                q1.add(cur % 10);
            } else {
                q2.add(cur % 10);
            }
            cur /= 10;
        }

        int res = 0;
        for (int i = 0; num > 0; i++) {
            int val = (num & 1) == 1 ? q1.poll() : q2.poll();
            res += Math.pow(10, i) * val;
            num /= 10;
        }
        return res;
    }
}
