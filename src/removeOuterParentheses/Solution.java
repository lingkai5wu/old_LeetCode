package removeOuterParentheses;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "()()";
        System.out.println(new Solution().removeOuterParentheses(s));
    }

    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0, j = -1; i < n; i++) {
            if (s.charAt(i) == '(') {
                if (cnt==0) {
                    j = i;
                }
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
            if (cnt == 0) {
                sb.append(s.subSequence(j + 1, i));
            }
        }
        return sb.toString();
    }
}
