package findMedianSortedArrays;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums1 = { 1, 3 }, nums2 = { 2 };
        System.out.println(new Solution().findMedianSortedArrays1(nums1, nums2));
        System.out.println(new Solution().findMedianSortedArrays2(nums1, nums2));
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length, l = l1 + l2, i = 0, j = 0;
        int[] nums = new int[l];

        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                nums[i + j] = nums1[i++];
            } else {
                nums[i + j] = nums2[j++];
            }
        }
        while (i < l1) {
            nums[i + j] = nums1[i++];
        }
        while (j < l2) {
            nums[i + j] = nums2[j++];
        }

        if (l % 2 == 1) {
            return nums[l / 2];
        } else {
            return 1.0 * (nums[l / 2 - 1] + nums[l / 2]) / 2;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        // 将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2)
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0)
            return nums2[start2 + k - 1];

        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
