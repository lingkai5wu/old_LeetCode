package minimumRounds;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] tasks = { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4 };
        System.out.println(new Solution().minimumRounds(tasks));
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int res = 0;
        for (int cnt : map.values()) {
            if (cnt > 1) {
                res += cnt / 3;
                if (cnt % 3 != 0) {
                    res++;
                }
            } else {
                return -1;
            }
        }
        return res;
    }
}
