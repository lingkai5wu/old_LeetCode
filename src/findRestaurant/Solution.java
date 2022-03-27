package findRestaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import array.StringArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" },
                list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
        StringArrayOperation.println(new Solution().findRestaurant(list1, list2));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        int m = list1.length, n = list2.length;
        for (int i = 0; i < m; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            String str = list2[j];
            if (map.containsKey(str)) {
                int index = map.get(str) + j;
                if (index < minIndex) {
                    minIndex = index;
                    res.clear();
                    res.add(str);
                } else if (index == minIndex) {
                    res.add(str);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
