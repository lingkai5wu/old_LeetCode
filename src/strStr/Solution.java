package strStr;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String haystack = "abeababeabf", needle = "abeabf";
        System.out.println(new Solution().strStr1(haystack, needle));
        System.out.println(new Solution().strStr2(haystack, needle));
    }

    public int strStr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }

        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();

        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = next[j - 1];
            }
            if (p[i] == p[j]) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = next[j - 1];
            }
            if (s[i] == p[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
