package contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2 {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] tasks = { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4 };
        System.out.println(new Q2().minimumRounds(tasks));
    }

    public int minimumRounds(int[] tasks) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            set.add(task);
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int res = 0;
        for (int task : set) {
            int cnt = map.get(task);
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
