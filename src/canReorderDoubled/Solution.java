package canReorderDoubled;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] arr = { 1, 2, 4, 16, 8, 4 };
        System.out.println(new Solution().canReorderDoubled(arr));
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int n : arr) {
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int val : cnt.keySet()) {
            list.add(val);
        }

        Collections.sort(list, (a, b) -> Math.abs(a) - Math.abs(b));
        for (int n : list) {
            if (cnt.getOrDefault(n * 2, 0) < cnt.get(n)) {
                return false;
            }
            cnt.put(n * 2, cnt.getOrDefault(n * 2, 0) - cnt.get(n));
        }
        return true;
    }
}