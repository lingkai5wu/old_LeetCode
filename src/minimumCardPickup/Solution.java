package minimumCardPickup;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] cards = { 3, 4, 2, 3, 4, 7 };
        System.out.println(new Solution().minimumCardPickup(cards));
    }

    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(cards[i])) {
                min = Math.min(i - map.get(cards[i]) + 1, min);
            }
            map.put(cards[i], i);
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}
