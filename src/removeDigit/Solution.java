package removeDigit;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        String number = "123";
        char digit = '3';
        System.out.println(new Solution().removeDigit(number, digit));
    }

    public String removeDigit(String number, char digit) {
        int n = number.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) != digit) {
                continue;
            }
            String str = number.substring(0, i) + number.substring(i + 1);
            if (res.compareTo(str) < 0) {
                res = str;
            }
        }
        return res;
    }
}
