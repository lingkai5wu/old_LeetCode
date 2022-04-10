package minimizeResult;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String expression = "12+34";
        System.out.println(new Solution().minimizeResult(expression));
    }

    public String minimizeResult(String expression) {
        String[] s = expression.split("\\+");
        int min = Integer.MAX_VALUE;
        String res = null;
        int m = s[0].length(), n = s[1].length();
        for (int i = 0; i < m; i++) {
            String a = s[0].substring(0, i), b = s[0].substring(i);
            for (int j = 1; j < n + 1; j++) {
                String c = s[1].substring(0, j), d = s[1].substring(j);
                int sum = getInt(a, 1) * (getInt(b, 0) + getInt(c, 0)) * getInt(d, 1);
                if (sum < min) {
                    min = sum;
                    res = String.format("%s(%s+%s)%s", a, b, c, d);
                }
            }
        }
        return res;
    }

    int getInt(String s, int n) {
        if (s.isEmpty()) {
            return n;
        }
        return Integer.parseInt(s);
    }
}
