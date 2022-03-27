package corpFlightBookings;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        int n = 5;
        IntegerArrayOperation.println(new Solution().corpFlightBookings(bookings, n));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            diff[i] += val;
            if (j + 1 < n) {
                diff[j + 1] -= val;
            }
        }
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
