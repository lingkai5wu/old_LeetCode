package romanToInt;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String s = "III";
        System.out.println(new Solution().romanToInt(s));
    }

    public int romanToInt(String s) {
        int num1 = 0, num2 = 0, sum = 0;
        for (int i = s.length(); i > 0; i--) {
            switch (s.charAt(i - 1)) {
            case 'I':
                num1 = 1;
                break;
            case 'V':
                num1 = 5;
                break;
            case 'X':
                num1 = 10;
                break;
            case 'L':
                num1 = 50;
                break;
            case 'C':
                num1 = 100;
                break;
            case 'D':
                num1 = 500;
                break;
            case 'M':
                num1 = 1000;
                break;
            }
            if (num1 < num2) {
                sum -= num1;
            } else {
                sum += num1;
            }
            num2 = num1;
        }
        return sum;
    }
}
