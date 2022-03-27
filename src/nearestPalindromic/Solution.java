package nearestPalindromic;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String n = "11";
        System.out.println(new Solution().nearestPalindromic(n));
    }

    public String nearestPalindromic(String str) {
        int n = str.length();
        long num = Long.parseLong(str);
        int preNum = Integer.parseInt(str.substring(0, (n + 1) / 2));

        long[] nums = new long[5];
        nums[0] = (long) (Math.pow(10, n - 1) - 1);
        nums[1] = (long) (Math.pow(10, n) + 1);
        for (int i = -1; i < 2; i++) {
            nums[3 + i] = getNum(preNum + i, n % 2 == 0);
        }

        long min = Long.MAX_VALUE;
        String res = null;
        for (int i = 0; i < 5; i++) {
            if (Math.abs(nums[i] - num) < min && nums[i] != num) {
                min = Math.abs(nums[i] - num);
                res = String.valueOf(nums[i]);
            }
        }

        return res;
    }

    long getNum(long k, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        sb.append(k);
        for (int i = sb.length() - (isEven ? 1 : 2); i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }
}
