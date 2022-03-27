package convertToBase7;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int num = -7;
        System.out.println(new Solution().convertToBase7(num));
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean flag = num < 0;
        if (flag) {
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        return (flag ? "-" : "") + sb.reverse().toString();
    }
}
