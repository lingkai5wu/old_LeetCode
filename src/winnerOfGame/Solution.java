package winnerOfGame;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String colors = "AAAABBBB";
		System.out.println(new Solution().winnerOfGame(colors));
	}

	public boolean winnerOfGame(String colors) {
		int cntA = 0, cntB = 0;
		int n = colors.length();
		for (int i = 1; i < n - 1; i++) {
			if (colors.charAt(i) == 'A') {
				if (colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
					cntA++;
				}
			} else {
				if (colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
					cntB++;
				}
			}
		}
		return cntA > cntB;
	}
}
