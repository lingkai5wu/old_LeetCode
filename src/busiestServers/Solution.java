package busiestServers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int k = 3;
        int[] arrival = { 1, 2, 3, 4, 5 }, load = { 5, 2, 3, 3, 3 };
        System.out.println(new Solution().busiestServers(k, arrival, load));
    }

    // 官方题解
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<Integer>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer p = available.ceiling(i % k);
            if (p == null) {
                p = available.first();
            }
            requests[p]++;
            busy.offer(new int[] { arrival[i] + load[i], p });
            available.remove(p);
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                ret.add(i);
            }
        }
        return ret;
    }
}
