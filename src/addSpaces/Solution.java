package addSpaces;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = { 8, 13, 15 };
        System.out.println(new Solution().addSpaces(s, spaces));
    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s.length() + spaces.length);
        int i = 0;
        for (int j : spaces) {
            sb.append(s.subSequence(i, j));
            sb.append(" ");
            i = j;
        }
        sb.append(s.substring(i));
        return sb.toString();
    }
}
