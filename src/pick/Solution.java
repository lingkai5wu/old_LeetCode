package pick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        Solution solution = new Solution(new int[] {1, 2, 3, 3, 3});
        System.out.println(solution.pick(3)); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
        System.out.println(solution.pick(1)); // 返回 0 。因为只有 nums[0] 等于 1 。
        System.out.println(solution.pick(3)); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    Random random = new Random();

    public Solution(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
