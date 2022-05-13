package oneEditAway;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String first = "pale", second = "pele";
        System.out.println(new Solution().oneEditAway(first, second));
    }

    public boolean oneEditAway(String first, String second) {
        int n = first.length(), m = second.length();
        if (Math.abs(n - m) > 1) {
            return false;
        }
        boolean flag = false;
        for (int i = 0, j = 0; i < n && j < m; i++, j++) {
            if (first.charAt(i) == second.charAt(j)) {
                continue;
            }
            if (flag) {
                return false;
            }
            flag = true;
            if (n < m) {
                i--;
            } else if (n > m) {
                j--;
            }
        }
        return true;
    }
}
