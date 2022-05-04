package findTheWinner;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int n = 5, k = 2;
        System.out.println(new Solution().findTheWinner1(n, k));
        System.out.println(new Solution().findTheWinner2(n, k));
        System.out.println(new Solution().findTheWinner3(n, k));
    }

    public int findTheWinner1(int n, int k) {
        Deque<Integer> q = new ArrayDeque<>(n);
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                q.add(q.poll());
            }
            q.poll();
        }
        return q.poll();
    }

    public int findTheWinner2(int n, int k) {
        if (n < 2) {
            return n;
        }
        return (k + findTheWinner2(n - 1, k) - 1) % n + 1;
    }

    public int findTheWinner3(int n, int k) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = (k + res - 1) % i + 1;
        }
        return res;
    }
}
