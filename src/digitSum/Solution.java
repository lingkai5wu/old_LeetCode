package digitSum;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "233";
        int k = 3;
        System.out.println(new Solution().digitSum(s, k));
    }

    public String digitSum(String s, int k) {
        while (s.length() > k) {
            int n = s.length();
            char[] cs = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i += k) {
                int sum = 0;
                for (int j = 0; j < k && i + j < n; j++) {
                    sum += cs[i + j] - '0';
                }
                sb.append(sum);
            }
            s = sb.toString();
        }
        return s;
    }
}
