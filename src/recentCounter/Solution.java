package recentCounter;

class RecentCounter {

    int[] times;
    int i, j;

    public RecentCounter() {
        times = new int[10000];
        i = j = 0;
    }

    public int ping(int t) {
        times[i++] = t;
        int left = j, right = i - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (times[mid] < t - 3000) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        j = left;
        return i - left;
    }
}

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1)); // requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(recentCounter.ping(100)); // requests = [1, 100]，范围是 [-2900,100]，返回 2
        System.out.println(recentCounter.ping(3001)); // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        System.out.println(recentCounter.ping(3002)); // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }

}
