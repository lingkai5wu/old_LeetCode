package lexicalOrder;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int n = 12;
        System.out.println(new Solution().lexicalOrder1(n));
        System.out.println(new Solution().lexicalOrder2(n));
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> lexicalOrder1(int n) {
        for (int i = 1; i < 10; i++) {
            dfs(i, n);
        }
        return res;
    }

    void dfs(int cur, int n) {
        if (cur > n) {
            return;
        }
        res.add(cur);
        for (int i = 0; i < 9; i++) {
            dfs(cur * 10 + i, n);
        }
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            res.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return res;
    }
}
