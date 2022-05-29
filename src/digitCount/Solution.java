package digitCount;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String num = "1210";
        System.out.println(new Solution().digitCount(num));
    }

    public boolean digitCount(String num) {
        int[] cnt = new int[10];
        for (char c : num.toCharArray()) {
            cnt[c - '0']++;
        }
        int n = num.length();
        for (int i = 0; i < n; i++) {
            if (cnt[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }
}
