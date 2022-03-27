package optimalDivision;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[] nums = { 1000, 100, 10, 2 };
        System.out.println(new Solution().optimalDivision(nums));
    }

    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
            if (i + 1 < n)
                sb.append("/");
        }
        if (n > 2) {
            sb.insert(sb.indexOf("/") + 1, "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
