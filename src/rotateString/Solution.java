package rotateString;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "abcde", goal = "cdeab";
        System.out.println(new Solution().rotateString(s, goal));
    }

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}