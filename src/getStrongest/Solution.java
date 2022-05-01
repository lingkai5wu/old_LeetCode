package getStrongest;

import java.util.Arrays;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 2;
        IntegerArrayOperation.println(new Solution().getStrongest(arr, k));
    }

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length, m = arr[(n - 1) / 2];
        int[] res = new int[k];
        int left = 0, right = n - 1;
        for (int i = 0; i < k; i++) {
            if (Math.abs(arr[left] - m) > Math.abs(arr[right] - m)
                    || Math.abs(arr[left] - m) == Math.abs(arr[right] - m) && arr[left] > arr[right]) {
                res[i] = arr[left++];
            } else {
                res[i] = arr[right--];
            }
        }
        return res;
    }
}
