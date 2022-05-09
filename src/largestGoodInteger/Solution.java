package largestGoodInteger;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String num = "232220002";
        System.out.println(new Solution().largestGoodInteger(num));
    }

    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String s = String.valueOf(i).repeat(3);
            if (num.contains(s)) {
                return s;
            }
        }
        return "";
    }
}
