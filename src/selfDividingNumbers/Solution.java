package selfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int left = 1, right = 22;
        System.out.println(new Solution().selfDividingNumbers1(left, right));
        System.out.println(new Solution().selfDividingNumbers2(left, right));
    }

    public List<Integer> selfDividingNumbers1(int left, int right) {
        List<Integer> res = new ArrayList<>();
        out: for (int i = left; i < right + 1; i++) {
            int cur = i;
            while (cur > 0) {
                int t = cur % 10;
                if (t == 0 || i % t != 0) {
                    continue out;
                }
                cur /= 10;
            }
            res.add(i);
        }
        return res;
    }

    static List<Integer> list = new ArrayList<>();
    static {
        out: for (int i = 0; i < 10001; i++) {
            int cur = i;
            while (cur > 0) {
                int t = cur % 10;
                if (t == 0 || i % t != 0) {
                    continue out;
                }
                cur /= 10;
            }
            list.add(i);
        }
    }

    public List<Integer> selfDividingNumbers2(int left, int right) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= left) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        while (list.get(r) <= right) {
            res.add(list.get(r++));
        }
        return res;
    }
}
