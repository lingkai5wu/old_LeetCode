package rotateString;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        String s = "abcde", goal = "cdeab";
        System.out.println(new Solution().rotateString(s, goal));
    }

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}