package contest;

public class Q1 {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "233";
        int k = 3;
        System.out.println(new Q1().digitSum(s, k));
    }

    public String digitSum(String s, int k) {
        while (s.length() > k) {
            int n = s.length();
            char[] cs = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n / k; i++) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += cs[i * k + j] - '0';
                }
                sb.append(sum);
            }
            if (n % k != 0) {
                int sum = 0;
                for (int i = n % k; i > 0; i--) {
                    sum += cs[n - i] - '0';
                }
                sb.append(sum);
            }
            s = sb.toString();
        }
        return s;
    }
}
