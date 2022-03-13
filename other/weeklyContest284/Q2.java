package weeklyContest284;

public class Q2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int n = 2;
		int[][] artifacts = { { 0, 0, 0, 0 }, { 0, 1, 1, 1 } }, dig = { { 0, 0 }, { 0, 1 } };
		System.out.println(new Q2().digArtifacts(n, artifacts, dig));
	}

	public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
		boolean[][] area = new boolean[n][n];
		for (int[] d : dig) {
			area[d[0]][d[1]] = true;
		}

		int res = 0;
		for (int[] is : artifacts) {
			boolean flag = true;
			for (int i = is[0]; i <= is[2] && flag; i++) {
				for (int j = is[1]; j <= is[3]; j++) {
					if (!area[i][j]) {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				res++;
			}
		}
		return res;
	}
}
