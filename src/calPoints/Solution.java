package calPoints;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String[] ops = { "5", "2", "C", "D", "+" };
		System.out.println(new Solution().calPoints(ops));
	}

	public int calPoints(String[] ops) {
		int[] nums = new int[1000];
		int n = 0;
		for (String s : ops) {
			switch (s.charAt(0)) {
			case '+':
				nums[n] = nums[n - 1] + nums[n - 2];
				break;
			case 'D':
				nums[n] = nums[n - 1] * 2;
				break;
			case 'C':
				n -= 2;
				break;
			default:
				nums[n] = Integer.parseInt(s);
				break;
			}
			n++;
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			res += nums[i];
		}
		return res;
	}
}
